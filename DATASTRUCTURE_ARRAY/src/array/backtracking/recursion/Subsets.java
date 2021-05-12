package array.backtracking.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {

        int[] num = new int[] { 1, 2, 3 };
        List<List<Integer>> result = subsets(num);
        System.out.println(result);

    }

    public static List<List<Integer>> subsets(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> l = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            subsetsDFS(nums, i, l, 0, new ArrayList<>());
        }
        return l;

    }

    // int[] nums = new int[] { 1, 2, 3 }
    public static void subsetsDFS(int[] nums, int currLength, List<List<Integer>> l, int start, List<Integer> curr) {
        
        if (curr.size() == currLength) {
            l.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            subsetsDFS(nums, currLength, l, i + 1, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
