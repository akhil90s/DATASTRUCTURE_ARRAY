package array;

public class Rotate_Array {

    // https://leetcode.com/problems/rotate-array/
    public static void main(String[] args) {

        int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        // int[] nums = new int[] {1,2};
        
        printArray(nums);
        rotateLeft_Approach_1(nums, 3);
        printArray(nums);
        // rotateLeft_Approach_2(nums, 3);
        // printArray(nums);
        
        // printArray(nums);
        // rotateRight_Approach_1(nums, 3);
        // printArray(nums);
        // rotateRight_Approach_2(nums, 3);
        // printArray(nums);

    }

    public static void rotateLeft_Approach_1(int[] nums, int k) {

        k = k % nums.length;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i - k >= 0) {
                result[i - k] = nums[i];
            } else {
                result[i - k + nums.length] = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }

    }
    
    // Will rotate left by k
    public static void rotateLeft_Approach_2(int[] nums, int k) {

        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);

    }

    public static void rotateRight_Approach_1(int[] nums, int k) {

        k = k % nums.length;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i + k < nums.length) {
                result[i + k] = nums[i];
            } else {
                result[i + k - nums.length] = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }

    }

    // Will rotate right by k
    public static void rotateRight_Approach_2(int[] nums, int k) {

        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    public static void reverse(int[] nums, int start, int end) {

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void printArray(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

    }

}
