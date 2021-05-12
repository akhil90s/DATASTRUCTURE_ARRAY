package array;

import java.util.ArrayList;
import java.util.List;

public class Summary_Ranges {

	// https://leetcode.com/problems/summary-ranges/
	public static void main(String[] args) {
		int[] array = new int[] { 0, 1, 2, 4, 5, 7 };
		List<String> result = summaryRanges(array);
		System.out.println(result);

	}

	public static List<String> summaryRanges(int[] array) {
		List<String> result = new ArrayList<>();
		int n = array.length;
		for (int i = 0; i < n; i++) {
			int start = array[i];
			while (i + 1 < n && (array[i + 1] == array[i] + 1)) {
				i++;
			}
			if (start != array[i]) {
				result.add("" + start + "->" + array[i]);
			} else {
				result.add("" + start);
			}
		}

		return result;
	}

}
