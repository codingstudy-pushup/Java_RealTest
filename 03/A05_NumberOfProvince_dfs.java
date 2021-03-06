package realTest03;

import java.util.*;

public class A05_NumberOfCity_dfs {

	public static void main(String[] args) {
		A05_NumberOfCity_dfs a = new A05_NumberOfCity_dfs();

		int[][] grid = { 
				{ 1, 1, 0 }, 
				{ 1, 1, 0 }, 
				{ 0, 0, 1 } };

//		int[][] grid = { 
//				{ 1, 0, 0 }, 
//				{ 0, 1, 0 }, 
//				{ 0, 0, 1 } };

//		int[][] grid = {
//				{1, 1, 0, 0, 0, 0},
//				{1, 1, 0, 0, 0, 0},
//     		    {0, 0, 1, 1, 1, 0},
//    		    {0, 0, 1, 1, 0, 0},
//    		    {0, 0, 1, 0, 1, 0},
//    		    {0, 0, 0, 0, 0, 1}
//    		    };

		System.out.println(a.solve(grid));
	}

	int n = 0;

	public int solve(int[][] grid) {
		// 1. ds
		n = grid.length;
		int[] visited = new int[n];
		int count = 0;

		// 2.for while
		for (int i = 0; i < n; i++) {
			if (visited[i] == 0) {
				dfs(grid, visited, i);
				count++;
			}
		}
		return count;
	}

	public void dfs(int[][] grid, int[] visited, int i) {
		for (int j = 0; j < n; j++) {
			System.out.println("grid["+i+"]["+j+"]"+ grid[i][j]+" visi["+j+"]"+visited[j]);
			if (grid[i][j] == 1 && visited[j] == 0) {
				System.out.println("grid[" + i + "][" + j + "] " + grid[i][j]);
				visited[j] = 1;
				dfs(grid, visited, j);
			System.out.println("=== ");
			}
			
		}
	}
}
