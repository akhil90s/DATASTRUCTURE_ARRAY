package array.windowslicing;

public class Maximum_Average_Subarray_I {

	public static void main(String[] args) {

		int[] array = new int[] { 1, 12, -5, -6, 50, 3 };
		// int[] array = new int[] { -1 };

		// double result = findMaxAverage(array, 1);
		double result = findMaxAverage_WindowSlicing(array, 1);

		System.out.println(result);

	}

	public static double findMaxAverage(int[] nums, int k) {

		double maxAverage = Double.MIN_VALUE;
		int lengthOfArrayTraversal = nums.length - k + 1;
		double sumOfKElements = 0;
		double averageOfKElements = 0;

		for (int i = 0; i < lengthOfArrayTraversal; i++) {
			sumOfKElements = 0;
			for (int j = i; j < i + k; j++) {
				sumOfKElements += nums[j];
			}
			averageOfKElements = sumOfKElements / k;
			if (lengthOfArrayTraversal == 1) {
				return averageOfKElements;
			}
			maxAverage = Math.max(maxAverage, averageOfKElements);
		}
		return maxAverage;
	}

	// Window Slicing Technique
	public static double findMaxAverage_WindowSlicing(int[] nums, int k) {

		double sum = 0;
		double average = Double.MIN_VALUE;

		for (int i = 0; i < k; i++) {
			sum += nums[i];
		}
		average = sum / k;

		int low = 1;
		int high = k;

		while (high < nums.length) {
			sum = sum - nums[low - 1] + nums[high];
			average = Math.max(average, sum / k);
			low++;
			high++;
		}
		return average;
	}

}
