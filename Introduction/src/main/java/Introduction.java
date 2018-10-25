public class Introduction {

	public static void main(String[] args) {
		long longVar = 1233444L;
		int intVar = 1;
		float floatVar = 893283783478.8874F;
		byte byteVar = 87;
		String string = "Hello!";
	}

	public long getSum(int a, int b, int c, int d) {
		return a * (b + (c / d));
	}

	public boolean getSumInLimit(int a, int b) {
		long sum = a + b;
		return sum >= 10 && sum <= 20;
	}

	public boolean isPositive(int a) {
		return a >= 0;
	}

	public boolean isNegative(int a) {
		return a < 0;
	}

	public void printHelloName(String name) {
		System.out.println("Hello, " + name + "!");
	}

	public void isLeapYear(int year) {
		boolean isLeapYear = year % 4 == 0 && !(year % 100 == 0 && year % 400 != 0);

		if (isLeapYear) {
			System.out.println(year + " is leap year");
		} else {
			System.out.println(year + " is not leap year");
		}
	}

}