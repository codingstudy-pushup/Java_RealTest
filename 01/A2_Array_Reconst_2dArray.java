package realtest01;

import java.util.*;

public class A2_Array_Reconst_2dArray {

	public static void main(String[] args) {

		int upper = 2, lower = 2;
		int[] colsum = { 2, 1, 1 };
		System.out.println(solve(upper, lower, colsum));
	}

	public static List<List<Integer>> solve(int upper, int lower, int[] colsum) {
		// 1. ds
		List<List<Integer>> res = new ArrayList<>();
		int n = colsum.length; // 3
		int[] a1 = new int[n];// 3
		int[] a2 = new int[n];

		// 2. for
		for (int i = 0; i < n; i++) {
			if (colsum[i] == 2) {
				a1[i] = 1;
				a2[i] = 1;
				upper--; // 2->1
				lower--;// 2->1
			} else if (colsum[i] == 1) {
				if (upper >= lower) {
					a1[i] = 1;
					upper--; // 1->0
				} else {
					a2[i] = 1;
					lower--;
				}
			} else if (colsum[i] == 0) {
				a1[i] = 0;
				a2[i] = 0;
			}
		}
		if(upper !=0 || lower !=0)
			return res;
		
		List<Integer> list = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for(int k : a1) {
			list.add(k);
		}
		for(int m : a2) {
			list2.add(m);
		}
		res.add(list);
		res.add(list2);
		return res;
	}
}
