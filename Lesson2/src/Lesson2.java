import java.util.Arrays;

public class Lesson2 {

	public static void main(String[] args) {
		reverseArray();
		System.out.println();
		printArrayWithStep();
		System.out.println();
		multiplyArray();
		System.out.println();
		printMatrix();
		System.out.println();

		int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
		System.out.println(getMaxFromArray(arr));
		System.out.println(getMinFromArray(arr));
		System.out.println();

		int[] arr1 = {1, 1, 1, 2, 1};
		System.out.println(checkBalance(arr1));

		int[] arr2 = {2, 1, 1, 2, 1};
		System.out.println(checkBalance(arr2));

		int[] arr3 = {10, 0, 10};
		System.out.println(checkBalance(arr3));
		System.out.println();

		System.out.println(Arrays.toString(shiftToStep(arr, 19)));
	}

	private static void reverseArray() {
		int[] bits = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
		int n = bits.length;

		for (int i = 0; i < n; i++) {
			bits[i] = Math.abs(bits[i] - 1);
		}

		System.out.println(Arrays.toString(bits));
	}

	private static void printArrayWithStep() {
		int n = 8;
		int[] arr = new int[n];
		int step = 3;

		arr[0] = 0;

		for (int i = 1; i < n; i++) {
			arr[i] = arr[i - 1] + step;
		}

		System.out.println(Arrays.toString(arr));
	}

	private static void multiplyArray() {
		int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			if (arr[i] < 6) {
				arr[i] *= 2;
			}
		}

		System.out.println(Arrays.toString(arr));
	}

	private static void printMatrix() {
		int n = 5;
		int[][] arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j || n - i - 1 == j) {
					arr[i][j] = 1;
				} else {
					arr[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}

	private static int getMaxFromArray(int[] arr) {
		int max = Integer.MIN_VALUE;
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			max = Math.max(max, arr[i]);
		}

		return max;
	}

	private static int getMinFromArray(int[] arr) {
		int min = Integer.MAX_VALUE;
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			min = Math.min(min, arr[i]);
		}

		return min;
	}

	private static boolean checkBalance(int[] arr) {
		int n = arr.length;
		boolean check = false;
		int leftSum = arr[0];
		int rightSum = arr[n - 1];

		if (leftSum == rightSum) {
			return true;
		}

		int middleIndex = n / 2;

		for (int i = 1; i < middleIndex; i++) {
			leftSum += arr[i];
			rightSum += arr[n - i];

			if (leftSum == rightSum) {
				 check = true;
				 break;
			}
		}

		if (!check && n % 2 != 0) {
			int middleItem = arr[middleIndex + 1];
			check = (leftSum + middleItem == rightSum);

			if (!check) {
				check = (leftSum == middleItem + rightSum);
			}
		}

		return check;
	}

	private static int[] shiftToStep(int[] arr, int n) {
		int length = arr.length;

		if (n == 0) {
			return arr;
		}

		if (Math.abs(n) >= length) {
			return new int[length];
		}

		if (n > 0) {
			for (int i = length - 1; i >= 0; i--) {
				if (i - n >= 0) {
					arr[i] = arr[i - n];
				} else {
					arr[i] = 0;
				}
			}
		}

		if (n < 0) {
			n = Math.abs(n);

			for (int i = 0; i < length; i++) {
				if (i + n < length) {
					arr[i] = arr[i + n];
				} else {
					arr[i] = 0;
				}
			}
		}

		return arr;
	}
}
