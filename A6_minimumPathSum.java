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

	int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 } };
	int m, n;
	public int solve(int[][] grid) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
		m = grid.length;
		n = grid[0].length;
		int[][] dp = new int[m][n]; // dp[i][j] min sum to reach grid[i][j].
		boolean[][] visited = new boolean[m][n];
		pq.add(new int[] { 0, 0, grid[0][0] });
		visited[0][0] = true;
		
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			for (int[] dir : dirs) {
				int x = cur[0] + dir[0];
				int y = cur[1] + dir[1];
				if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y])
					continue;
				int[] next = new int[] { x, y, cur[2] + grid[x][y] };
				if (next[0] == m - 1 && next[1] == n - 1)
					return next[2];
				visited[x][y] = true;
				pq.add(next);
			}
		}
		return grid[0][0]; 
	}
}
