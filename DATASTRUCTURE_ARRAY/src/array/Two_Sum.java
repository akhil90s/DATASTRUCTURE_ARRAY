package array;
import java.util.HashMap;
import java.util.Map;

public class Two_Sum {

	// https://leetcode.com/problems/two-sum/
	public static void main(String[] args) {

		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int[] result_1 = twoSum_1(nums, target);
		int[] result_2 = twoSum_2(nums, target);
		printArray(result_1);
		System.out.println();
		printArray(result_2);


	}

	// time complexity : O(n2)
	public static int[] twoSum_1(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if ((nums[i] + nums[j]) == target) {
					return new int[] { i, j };
				}
			}
		}
		return null;
	}

	// time complexity : O(n)
	public static int[] twoSum_2(int[] nums, int target) {

		Map<Integer, Integer> numMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			
			int complement = target - nums[i];
			if (numMap.containsKey(complement)) {
				return new int[] { i, numMap.get(complement) };
			} else {
				numMap.put(nums[i], i);
			}
		
		}

		return null;
	}

	public static void printArray(int[] result) {

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}

	}
}
