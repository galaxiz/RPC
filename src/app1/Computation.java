/**
 * 
 */
package app1;

/**
 * @author air
 *
 */
public class Computation {

	public static int computeFactorial(int i) {
		if(i <= 0)
			return 0;
		if(i == 1)
			return i;
		return Computation.computeFactorial(i-1)*i;
	}
}
