package array;

public class Sorting_0s_And_1s_In_An_Array {

	public static void main(String[] args) {

		int[] array = { 0, 1, 0, 1, 0, 0, 1, };
		// sort0sAnd1sInAnArray_Approach1(array);
		// printArray(array);

		// sort0sAnd1sInAnArray_Approach2(array);
		// printArray(array);

		sort0sAnd1sInAnArray_Approach3(array);
		printArray(array);

	}

	public static void sort0sAnd1sInAnArray_Approach1(int[] array) {

		int n = array.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			int temp = array[i];
			if (temp == 0) {
				count++;
			}
		}

		for (int i = 0; i < count; i++) {
			array[i] = 0;
		}

		for (int i = count; i < n; i++) {
			array[i] = 1;
		}

	}

	public static void sort0sAnd1sInAnArray_Approach2(int[] array) {

		int left = 0;
		int right = array.length - 1;

		while (left < right) {
			
			while (array[left] == 0 && left < right) {
				left++;
			}
			
			while (array[right] == 1 && left < right) {
				right--;
			}

			if (left < right) {
				array[left] = 0;
				array[right] = 1;
				left--;
				right++;
			}
		}

	}

	public static void sort0sAnd1sInAnArray_Approach3(int[] array) {

		int n0 = 0;
		int n1 = array.length -1;

		while (n0 < n1) {
			if (array[n0] == 1) {
				array[n1] = array[n1] + array[n0];
				array[n0] = array[n1] - array[n0];
				array[n1] = array[n1] - array[n0];
				n1--;
			} else {
				n0++;
			}
		}

	}

	public static void printArray(int[] array) {
		int n = array.length;
		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
