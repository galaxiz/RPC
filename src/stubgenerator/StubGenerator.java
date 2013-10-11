package stubgenerator;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

/**
 * 
 * @author xi
 * 
 * Stub Generator:
 */
public class StubGenerator {
	/*
	 * For primitive data types, return the name of wrapper class.
	 */
	public static String priName(String pri) {
		switch (pri) {
		case "byte":
			return "Byte";
		case "short":
			return "Short";
		case "int":
			return "Integer";
		case "long":
			return "Long";
		case "float":
			return "Float";
		case "double":
			return "Double";
		case "char":
			return "Character";
		case "boolean":
			return "Boolean";
		default:
			return "";
		}
	}
	
	public static void usage(){
		System.out.println("Usage:java stubgenerator.StubGenerator <Package.ClassName>");
		System.exit(1);
	}

	/*
	 * Input a .class file, generate a .stub class file. 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		if(args.length!=1){
			usage();
		}		
		
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();

		Class c = Class.forName(args[0]);
		Class[] ifs = c.getInterfaces();

		StringWriter writer = new StringWriter();
		PrintWriter out = new PrintWriter(writer);
		
		/*
		 * generate source
		 */
		out.println(c.getPackage() + ";");
		out.println("import remoteinterface.Remote_Stub;");
		out.println("import rmimessage.InvocationMsg;");
		out.println("import rmimessage.ReturnMSG;");
		out.println("import communication.ClientCM;");
		out.println("import exception.RemoteException;");
		out.print("public class " + c.getSimpleName() + "_stub extends Remote_Stub implements ");

		ArrayList<String> methodNames = new ArrayList<String>();

		boolean first=true;
		for (Class itf : ifs) {
			Class[] subInterfaces = itf.getInterfaces();
			boolean remotable = false;
			for (Class sitf : subInterfaces) {
				if (sitf.getName().equals("remoteinterface.Remote")) {
					remotable = true;
					break;
				}
			}

			if (remotable) {
				Method[] mtds = itf.getMethods();

				for (Method m : mtds) {
					methodNames.add(m.getName());
				}
				
				if(!first){
					out.print(",");
				}
				
				out.print(itf.getName());
				
				first=false;
			}
		}

		out.println("{");

		for (Method m : c.getMethods()) {
			System.out.println(m.toString());

			if (methodNames.contains(m.getName())) {
				StringBuilder arbr=new StringBuilder("");
				arbr.append("(");
				int i=0;
				for (Class t : m.getParameterTypes()) {
					if (i!=0) {
						arbr.append(",");
					}
					arbr.append(t.getName()+" ");
					arbr.append((char)('a'+i));
					i++;
				}
				arbr.append(")");
				
				String newState=m.toString().replaceAll("\\(.*\\)",arbr.toString());
				newState=newState.replaceAll("( )([^ ]*\\.)([^\\.]*\\()","$1$3");
				out.println(newState+"{");
				
				out.print("InvocationMsg msg = new InvocationMsg(\""
						+ c.getName() + "\",\"" + m.getName()
						+ "\", new Class[] {");
				first = true;
				for (Class t : m.getParameterTypes()) {
					if (!first) {
						out.print(",");
					}
					if (t.isPrimitive()) {
						out.print(priName(t.getName()) + ".TYPE");
					} else {
						out.print(t.getName() + ".class");
					}
					first = false;
				}
				out.print("},new Object[] {");
				i=0;
				for (Class t : m.getParameterTypes()) {
					if (i!=0) {
						out.print(",");
					}
					out.print((char)('a'+i));
					i++;
				}
				out.println("});");
				out.println("clientCM.sendMessage(msg);");
				out.println("ReturnMSG rtmsg = (ReturnMSG) clientCM.receiveMessage();");
				
				if (!m.getReturnType().toString().equals("void")) {
					out.print("return (");
					if (m.getReturnType().isPrimitive()) {
						out.print(priName(m.getReturnType().getName()));
					} else {
						out.print(m.getReturnType().getName());
					}
					out.println(")rtmsg.getReturnObject();");
				}
				out.println("}");
			}
		}
		
		out.println("}");
		out.close();
		
		JavaFileObject fileObject = new JavaSourceFromString(c.getSimpleName() + "_stub",
				writer.toString());
		Iterable<? extends JavaFileObject> cu = Arrays
				.asList(fileObject);
		
		CompilationTask task = compiler.getTask(null, null, diagnostics, null,
				null, cu);		
		
		/*
		 * compiling
		 */
		boolean success = task.call();
		
		for (Diagnostic d : diagnostics.getDiagnostics()) {
			System.out.println(d.getCode() + " " + d.getKind() + " " + d.getPosition()+ " " + d.getMessage(null));
		}

		System.out.println("Success: " + success);		
	}
}

class JavaSourceFromString extends SimpleJavaFileObject {
	final String code;

	public JavaSourceFromString(String name, String code) {
		super(URI.create("string:///" + name.replace('.', '/')
				+ Kind.SOURCE.extension), Kind.SOURCE);
		this.code = code;
	}

	public CharSequence getCharContent(boolean ignoreEncodingErrors) {
		return code;
	}
}