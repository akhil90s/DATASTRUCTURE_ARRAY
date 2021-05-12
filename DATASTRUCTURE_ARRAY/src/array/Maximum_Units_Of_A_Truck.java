package array;

import java.util.Arrays;

public class Maximum_Units_Of_A_Truck {

	public static void main(String[] args) {
		int[][] boxTypes = {{1,3},{2,2},{3,1}}; 
        int truckSize = 4;
		int maximumUnits = maximumUnits(boxTypes, truckSize);
		System.out.println(maximumUnits);
	}

	// https://leetcode.com/problems/maximum-units-on-a-truck/
	public static int maximumUnits(int[][] boxTypes, int truckSize) {
		Arrays.sort(boxTypes, (a, b) -> -Integer.compare(a[1], b[1]));
		int maxResult = 0;
		for (int[] box : boxTypes) {
			if (truckSize < box[0]) {
				return maxResult + truckSize * box[1];
			}
			maxResult += box[0] * box[1];
			truckSize -= box[0];
		}
		return 0;
	}

}
