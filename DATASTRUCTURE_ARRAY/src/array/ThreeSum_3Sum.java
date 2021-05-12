package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_3Sum {

	// https://leetcode.com/problems/3sum/
	public static void main(String[] args) {

		int nums[] = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> result = threeSum(nums);
		printList(result);
	}

	// time complexity = O(n2)
	public static List<List<Integer>> threeSum(int[] nums) {

		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {

				int sum = 0 - nums[i];
				int low = i + 1;
				int high = nums.length - 1;

				while (low < high) {
					if (nums[low] + nums[high] == sum) {
						result.add(Arrays.asList(nums[i], nums[low], nums[high]));
						while (low < high && nums[low] == nums[low + 1]) {
							low++;
						}
						while (low < high && nums[high] == nums[high - 1]) {
							high--;
						}
						low++;
						high--;
					} else if (nums[low] + nums[high] > sum) {
						high--;
					} else {
						low++;
					}
				}
			}
		}
		return result;
	}

	public static void printList(List<List<Integer>> result) {

		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

}
