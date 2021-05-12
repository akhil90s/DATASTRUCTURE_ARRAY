package array;

public class Search_Insert_Position {

	public static void main(String[] args) {

		int[] nums = { 1, 3, 5, 6 };
		int result = searchInsertPosition(nums, 4);
		System.out.println(result);

	}

	// https://leetcode.com/problems/search-insert-position/
	// Using Binary Search
	public static int searchInsertPosition(int[] nums, int target) {

		int n = nums.length;
		
		if (n < 1) {
			return 0;
		}
		int low = 0;
		int high = n - 1;
		int mid = 0;
		int pos = 0;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (target == nums[mid]) {
				return mid;
			} else if (nums[mid] > target) {
				high = mid - 1;
				pos = mid;
			} else {
				low = mid + 1;
				pos = mid + 1;
			}
		}
		return pos;
	}
}




