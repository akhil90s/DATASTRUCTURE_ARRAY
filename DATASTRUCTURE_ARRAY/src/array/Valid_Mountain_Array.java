package array;

public class Valid_Mountain_Array {

	// https://leetcode.com/problems/valid-mountain-array/
	public static void main(String[] args) {

		int[] arr = new int[] { 0, 2, 3, 4, 5, 5, 2, 1 };
		boolean result = validMountainArray(arr);
		System.out.println(result);

	}

	public static boolean validMountainArray(int[] arr) {

		int i = 0;
		int N = arr.length;

		// walk up the mountain
		while (i + 1 < N && arr[i] < arr[i + 1])
			i++;

		// peak can't be the first or last
		if (i == 0 || i == N - 1)
			return false;

		// walk down the mountain
		while (i + 1 < N && arr[i + 1] < arr[i])
			i++;

		return i == N - 1;
	}

}
