package realTest04;

import java.util.*;

public class A05_ShortestPathMatrix {

	public static void main(String[] args) {
		A05_ShortestPathMatrix a = new A05_ShortestPathMatrix();
		int[][] grid = { 
				{ 0, 0, 0 }, 
				{ 1, 1, 0 }, 
				{ 1, 1, 0 }
				};
		System.out.println(a.solve(grid));

	}
	int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, -1 }, { -1, 1 }, { -1, -1 }, { 1, 1 } };
	public int solve(int[][] grid) {

		int m = grid.length;
		int n = grid[0].length;

		if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
			return -1;
		}

		boolean[][] visited = new boolean[m][n];
		visited[0][0] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0 });
		int count = 0;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] cur = queue.remove();
				if (cur[0] == m - 1 && cur[1] == n - 1) {
					return count + 1;
				}
				for (int[] dir : dirs) {
					int newX = cur[0] + dir[0];
					int newY = cur[1] + dir[1];
					if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]
							&& grid[newX][newY] == 0) {
						queue.add(new int[] { newX, newY });
						visited[newX][newY] = true;
					}
				}
			}
			count++;
		}

		return -1;
	}
}
