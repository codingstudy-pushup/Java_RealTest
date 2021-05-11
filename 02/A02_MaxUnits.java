package realTest02;

import java.util.*;

public class A02_MaxUnits {

	public static void main(String[] args) {
		int[][] boxTypes = { 
				{ 1, 3 },
				{ 2, 2 }, 
				{ 3, 1 } };
		int truckSize = 4;
		System.out.println(solve(boxTypes, truckSize));
	}

	public static int solve(int[][] boxTypes, int truckSize) {
		Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
		int unitCount = 0;
		for (int[] boxType : boxTypes) {
			int boxCount = Math.min(truckSize, boxType[0]);
			unitCount += boxCount * boxType[1];
			truckSize -= boxCount;
			if (truckSize == 0)
				break;
		}
		return unitCount;
	}
}
