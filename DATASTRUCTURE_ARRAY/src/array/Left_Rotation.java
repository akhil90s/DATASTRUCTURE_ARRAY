package array;

public class Left_Rotation {

	public static void main(String[] args) {

		int[] array = new int[] { 1, 3, 5, 7, 9 };
		arrayLeftRotation(array, 2);

	}

	public static void arrayLeftRotation(int[] array, int d) {

		printArray(array);
		int n = array.length;
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			int temp = i - d;
			if (temp >= 0) {
				result[temp] = array[i];
			} else {
				result[temp + n] = array[i];
			}
		}
		printArray(result);
	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

}
