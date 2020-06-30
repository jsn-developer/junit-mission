package level1;

public class Math {

	/**
	 * 足し算
	 */
	public int add(int a, int b) {
		return a + b;
	}

	/**
	 * 引き算
	 */
	public int subtraction(int a, int b) {
		return a - b;
	}

	/**
	 * 掛け算
	 */
	public int multiplication(int a, int b) {
		return a * b;
	}

	/**
	 * 割り算
	 */
	public double division(int a, int b) {
		return (double) a / (double) b;
	}

	/**
	 * 絶対値を用いた足し算
	 */
	public int absoluteAdd(int a, int b) {

		if(a < 0) {
			a = a * -1;
		}

		if (b < 0) {
			b = b * -1;
		}

		return a + b;
	}
}
