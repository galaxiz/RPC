package stubgenerator;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
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
import javax.tools.JavaFileObject.Kind;

import rmimessage.InvocationMsg;
import rmimessage.ReturnMSG;
import exception.RemoteException;

/**
 * 
 * @author xi
 * 
 *         Stub Generator
 */
public class StubGenerator {
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

	public static void main(String[] args) throws ClassNotFoundException {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();

		Class c = Class.forName("testfactorial.Computation");
		Class[] ifs = c.getInterfaces();

		StringWriter writer = new StringWriter();
		PrintWriter out = new PrintWriter(writer);
		out.println(c.getPackage() + ";");
		out.println("public class " + c.getSimpleName() + "_stub{");

		ArrayList<String> methodNames = new ArrayList<String>();

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
			}
		}

		for (Method m : c.getMethods()) {
			System.out.println(m.toString());

			if (methodNames.contains(m.getName())) {
				out.println(m.toGenericString() + "{");
				
				m.toGenericString().replaceAll("\(.*\)", replacement
				
				out.print("InvocationMsg msg = new InvocationMsg(\""
						+ c.getName() + "\",\"" + m.getName()
						+ "\", new Class[] {");
				boolean first = true;
				for (Class t : m.getParameterTypes()) {
					if (!first) {
						out.print(",");
					}
					if (t.isPrimitive()) {
						out.print(priName(t.getName()) + ".Type");
					} else {
						out.print(t.getName() + ".class");
					}
					first = false;
				}
				out.println("},new Object[] {" + "});");
				out.println("clientCM.sendMessage(msg);");
				out.println("ReturnMSG rtmsg = (ReturnMSG) clientCM.receiveMessage();");
				out.println("return (" + m.getReturnType().toString()
						+ ")rtmsg.getReturnObject();");
				out.println("}");
			}
		}

		Method[] ms = ifs[0].getDeclaredMethods();

		// public int computeSum(int i, int j) throws RemoteException {
		// InvocationMsg msg = new InvocationMsg("testfactorial.Computation",
		// "computeSum", new Class[] { Integer.TYPE, Integer.TYPE },
		// new Object[] { i, j });
		// clientCM.sendMessage(msg);
		// ReturnMSG rtmsg = (ReturnMSG) clientCM.receiveMessage();
		// return (Integer)rtmsg.getReturnObject();
		// }

		out.println("  public static void main(String args[]) {");
		out.println("    System.out.println(\"This is in another java file\");");
		out.println("  }");
		out.println("}");
		out.close();
		JavaFileObject file = new JavaSourceFromString("HelloWorld",
				writer.toString());

		Iterable<? extends JavaFileObject> compilationUnits = Arrays
				.asList(file);
		CompilationTask task = compiler.getTask(null, null, diagnostics, null,
				null, compilationUnits);

		boolean success = task.call();
		for (Diagnostic diagnostic : diagnostics.getDiagnostics()) {
			System.out.println(diagnostic.getCode());
			System.out.println(diagnostic.getKind());
			System.out.println(diagnostic.getPosition());
			System.out.println(diagnostic.getStartPosition());
			System.out.println(diagnostic.getEndPosition());
			System.out.println(diagnostic.getSource());
			System.out.println(diagnostic.getMessage(null));
		}

		System.out.println("Success: " + success);

		if (success) {
			try {
				Class.forName("HelloWorld")
						.getDeclaredMethod("main",
								new Class[] { String[].class })
						.invoke(null, new Object[] { null });
			} catch (ClassNotFoundException e) {
				System.err.println("Class not found: " + e);
			} catch (NoSuchMethodException e) {
				System.err.println("No such method: " + e);
			} catch (IllegalAccessException e) {
				System.err.println("Illegal access: " + e);
			} catch (InvocationTargetException e) {
				System.err.println("Invocation target: " + e);
			}
		}

	}
}

class JavaSourceFromString extends SimpleJavaFileObject {
	final String code;

	public JavaSourceFromString(String name, String code) {
		super(URI.create("string:///" + name.replace('.', '/')
				+ Kind.SOURCE.extension), Kind.SOURCE);
		this.code = code;
	}

	@Override
	public CharSequence getCharContent(boolean ignoreEncodingErrors) {
		return code;
	}
}