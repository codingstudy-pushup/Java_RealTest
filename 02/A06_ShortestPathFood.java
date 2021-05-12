package realTest02;

import java.util.*;

public class A06_ShortestPathFood {

	public static void main(String[] args) {
		A06_ShortestPathFood a = new A06_ShortestPathFood();
		char[][] grid = { 
				{ 'X', 'X', 'X', 'X', 'X', 'X' }, 
				{ 'X', 'I', 'O', 'O', 'O', 'X' },
				{ 'X', 'O', 'O', 'F', 'O', 'X' }, 
				{ 'X', 'X', 'X', 'X', 'X', 'X' } };
		System.out.println(a.solve(grid));
	}

	int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	int m = 0, n = 0;

	public int solve(char[][] grid) {
		m = grid.length;
		n = grid[0].length;
		int count = 0;
		boolean[][] visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 'I') {
					count = bfs(grid, i, j, visited);
					break;
				}
			}
		}
		return count;
	}

	public int bfs(char[][] grid, int x, int y, boolean[][] visited) {
		visited[x][y] = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y, 0 });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int[] dir : dirs) {
				int x1 = cur[0] + dir[0];
				int y1 = cur[1] + dir[1];
//		        if(x1<0 || x1>= m || y1<0 || y1>=n|| visited[x1][y1] == true || grid[x1][y1] == 'X')
//		             continue;
				if (x1 >= 0 && y1 >= 0 && x1 < m && y1 < n && visited[x1][y1] != true && grid[x1][y1] != 'X') {
					if (grid[cur[0]][cur[1]] == 'F') {
						return cur[2];
					}
					visited[x][y] = true;
					q.offer(new int[] { x1, y1, cur[2] + 1 });

				}
			}
		}
		return -1;
	}
}

