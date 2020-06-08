package api;

/**
 * 
 * @author unascribed
 * @since JDK8
 * <br>
 * Calculator.
 *
 */
public class Calc {
	/**
	 * To add the following numbers.<br>
	 * For example<br>
	 * <code>
	 *		add(1,3) : 4<br>
	 * </code>
	 * @param num1 : First Integer for add
	 * @param num2 : Last Integer for add
	 * @return num1 + num2
	 * @see Math
	 */
	public int add(int num1, int num2) {
		return num1 + num2;
	}
	
	public static void main(String[] args) {
		new Calc().add(5, 6);
	}
}






