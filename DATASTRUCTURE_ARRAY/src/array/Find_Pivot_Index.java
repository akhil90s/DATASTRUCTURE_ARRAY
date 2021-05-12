package array;

public class Find_Pivot_Index {

	public static void main(String[] args) {

		//int[] array = new int[] { 1, 7, 3, 6, 5, 6 };
		//int[] array = new int[] { 1, 2, 3 };
		//int[] array = new int[] { 2, 1, -1 };
		int[] array = new int[] { -1,-1,-1,-1,-1,-1 };
		
		int result = pivotIndex(array);
		System.out.println(result);

	}


	// total_sum - nums[i] - left_sum == left_sum
	public static int pivotIndex(int[] nums) {
		int total_sum = 0;
		for (int i = 0; i < nums.length; i++) {
			total_sum += nums[i];
		}
		int left_sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i != 0) {
				left_sum += nums[i - 1];
			}
			if ((total_sum - nums[i] - left_sum) == left_sum) {
				return i;
			}
		}
		return -1;
	}

}
