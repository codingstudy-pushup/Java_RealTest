package realtest01;

import java.util.*;

public class A3_TwoSum_60Sec {

	public static void main(String[] args) {

//		int[] time = {30,20,150,100,40,90,30};
		int[] time = { 30, 30, 20, 150, 100, 40 };
//		int[] time = { 30, 20, 150, 100, 40, 30 };
//		int[] time = { 30, 30, 30 };
//		int[] time = {30,60,150,100,40,80,120};
		System.out.println(solve01(time));
		System.out.println(solve_type(time));
//		System.out.println(solve_map(time));

	}

	public static int solve01(int[] time) {
		int count = 0, n = time.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				System.out.println(time[i] + " " + time[j]);
				if ((time[i] + time[j]) % 60 == 0) {
					count++;
				}
			}
		}
		return count;
	}

	// 2
	public static int solve_type(int[] time) {
		int[] types = new int[60];
		for (int i = 0; i < time.length; i++) {
			int key = time[i] % 60;
			types[key] += 1;
		}

		int counter = 0;
		if (types[0] > 0) {
			counter += types[0] * (types[0] - 1) / 2;
		}
		if (types[30] > 0) {
			counter += types[30] * (types[30] - 1) / 2;
		}
		for (int i = 1; i < 30; i++) {
			counter += (types[i] * types[60 - i]);
		}
		return counter;
	}

	// 3
	public static int solve_map(int[] time) {
		Map<Integer, Integer> map = new HashMap();
		int total = 0;

		for (int t : time) {
			int val = t % 60;
			map.put(val, map.getOrDefault(val, 0) + 1);
		}

		for (int num : time) {
			num %= 60;
			int diff = (60 - num) % 60;

			if (map.containsKey(diff)) {
				int count = map.get(diff);
				if (count == 0 || (diff == num && count == 1))
					continue;
				System.out.println("diff " + diff + " num " + num);
				total += diff == num ? count - 1 : count;
				map.put(num, map.get(num) - 1);
			}
		}
		return total;
	}

}
