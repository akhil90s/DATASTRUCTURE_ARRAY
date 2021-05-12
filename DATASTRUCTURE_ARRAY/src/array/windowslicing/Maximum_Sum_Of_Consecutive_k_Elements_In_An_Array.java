
package array.windowslicing;

public class Maximum_Sum_Of_Consecutive_k_Elements_In_An_Array {

	public static void main(String[] args) {
		
		int array[] = { 1, 4, 2, 10, 23, 3, 1, 0, 20 };
		// We get maximum sum 39 by adding subarray {4, 2, 10, 23} of size 4 for k=4

		int result_Approach1 = maximumSum_Approach1(array, 4);
		System.out.println(result_Approach1);

		int result_Approach2 = maximumSum_Approach2(array, 4);
		System.out.println(result_Approach2);
		
	}

	// Technique : Brute Force Approach O(n*n)
	public static int maximumSum_Approach1(int[] array, int k) {
		int length = array.length;
		int max_sum = Integer.MIN_VALUE;

		for (int i = 0; i < length - k + 1; i++) {
			int current_sum = 0;
			for (int j = 0; j < k; j++) {
				current_sum = current_sum + array[i + j];
			}
			max_sum = Math.max(max_sum, current_sum);
		}
		return max_sum;
	}

	
	// Technique : Window Sliding O(n)
	public static int maximumSum_Approach2(int[] array, int k) {

		int length = array.length;
		int max_sum = 0;

		for (int i = 0; i < k; i++) {
			max_sum = max_sum + array[i];
		}

		int window_sum = max_sum;
		
		for (int i = k; i < length; i++) {
			window_sum = window_sum + (array[i] - array[i - k]);
			max_sum = Math.max(max_sum, window_sum);
		}

		return max_sum;
	}

}
