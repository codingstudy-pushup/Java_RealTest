package realtest01;

import java.util.*;

public class A6_minimumPathSum {

	public static void main(String[] args) {
		A6_minimumPathSum a = new A6_minimumPathSum();
		int[][] grid = { 
			{ 2, 4, 1 }, 
			{ 3, 8, 1 },
			{ 4, 5, 1 } };
		System.out.println(a.solve(grid));
	}

	int m, n;
	int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public int solve(int[][] grid) {
		// 1.
		m = grid.length;
		n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		// minHeap
		Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		pq.add(new int[] { 0, 0, grid[0][0] });
		visited[0][0] = true;

		// 2
		while (!pq.isEmpty()) {
			int[] cur = pq.poll(); // 0,0,2
			for (int[] dir : dirs) {
				int x = cur[0] + dir[0];
				int y = cur[1] + dir[1];

				if (x >= 0 && y >= 0 && x < m && y < n && !visited[x][y]) {
					int[] next = new int[] { x, y, cur[2] + grid[x][y] };
					if (next[0] == m - 1 && next[1] == n - 1) {
						return next[2];
					}
					visited[x][y] = true;
					print(next);
					System.out.println("============");
					print_bool(visited);
					pq.add(next);
				}

			}

		}
		return grid[0][0];

	}
	
	void print(int[] grid) {
		for (int i = 0; i < grid.length; i++) {
			System.out.println("grid["+i+"] "+grid[i]+" ");
		}
		System.out.println("");
	}
	
	void print(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
//			System.out.print("grid["+i+"] "+grid[i].length+"\t");
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}
	
	public void print_bool(boolean[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n ; j++) {
				System.out.print(grid[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
