package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Merge_Intervals {

    // https://leetcode.com/problems/merge-intervals/
    public static void main(String[] args) {

        List<int[]> intervals = new ArrayList<>();
        intervals.add(new int[] { 1, 3 });
        intervals.add(new int[] { 15, 18 });
        intervals.add(new int[] { 8, 10 });
        intervals.add(new int[] { 2, 6 });
        intervals.add(new int[] { 5, 7 });

        List<int[]> result_1 = merge(intervals);
        printArray(result_1);

        int[][] intervals_mergeMatrixAsInput = new int[][] { { 1, 3 }, { 2, 6 }, { 15, 18 }, { 8, 10 } };
        int[][] result_2 = mergeMatrixAsInput(intervals_mergeMatrixAsInput);
        System.out.println(result_2);

    }

    public static List<int[]> merge(List<int[]> intervals) {

        Collections.sort(intervals, (array_1, array_2) -> Integer.compare(array_1[0], array_2[0]));
        List<int[]> output_array = new ArrayList<>();

        int current_interval[] = intervals.get(0);
        output_array.add(current_interval);

        for (int[] interval : intervals) {

            int current_end = current_interval[1];
            int next_begin = interval[0];
            int next_end = interval[1];

            if (current_end >= next_begin) {
                current_interval[1] = Math.max(current_end, next_end);
            } else {
                current_interval = interval;
                output_array.add(current_interval);
            }
        }

        return output_array;
    }

    public static int[][] mergeMatrixAsInput(int[][] intervals) {

        if (intervals.length <= 1)
            return intervals;

        Arrays.sort(intervals, Comparator.comparing(o -> o[0]));

        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        result.add(current);

        for (int[] interval : intervals) {

            int current_start = current[0];
            int current_end = current[1];

            int next_begin = interval[0];
            int next_end = interval[1];

            if (current_end >= next_begin) {
                current[1] = Math.max(current_end, next_end);
            } else {
                current = interval;
                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);

    }

    public static void printArray(List<int[]> result) {

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

}
