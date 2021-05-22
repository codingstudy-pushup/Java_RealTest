package realTest04;

import java.util.*;

public class A01_PrisonCellsAfterNdays {
	public static void main(String[] args) {
		A01_PrisonCellsAfterNdays a = new A01_PrisonCellsAfterNdays();
		int[] cells = { 1, 0, 0, 1, 0, 1, 0, 0 };
		int N = 17;
		int[] val = a.solve(cells, N);
		for (int i : val)
			System.out.print(i);
	}

	public int[] solve(int[] cells, int N) {
		if (cells == null || cells.length == 0 || N <= 0)
			return cells;
		boolean isCycle = false;
		int cycle = 0;
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			int[] next = nextDay(cells);
			String key = Arrays.toString(next);
			System.out.println(i + " " + key);
			if (!set.contains(key)) { // store cell state
				set.add(key);
				cycle++;
			} else {
				isCycle = true;
				break;
			}
			cells = next;
		}
		if (isCycle) {
			System.out.println("cycle: " + cycle + " N " + N);
			N %= cycle;
			System.out.println("N: " + N);
			for (int i = 0; i < N; i++) {
				cells = nextDay(cells);
			}
		}
		return cells;
	}

	private int[] nextDay(int[] cells) {
		int[] nums = new int[cells.length];
		for (int i = 1; i < cells.length - 1; i++) {
			nums[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
		}
		return nums;
	}

}
