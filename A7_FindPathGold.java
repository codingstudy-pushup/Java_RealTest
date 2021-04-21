package realtest01;

import java.util.*;

public class A7_FindPathGold {

	public static void main(String[] args) {
		A7_FindPathGold a = new A7_FindPathGold();
		int[][] grid = { 
				{ 8, 1, 0 },
				{ 0, 7, 6 }, 
				{ 0, 9, 0 } 
			};
		System.out.println(a.solve(grid));
	}

	int totalVal = 0;
	int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	int m, n;

	public int solve(int[][] grid) {
		//1.
		m = grid.length; //3
		n = grid[0].length; //3
		boolean[][] visited = new boolean[m][n];
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(grid[i][j] != 0) {
					dfs(grid, i, j, visited, 0);
				}
			}
		}
		return totalVal;
	}
	
	private void dfs(int[][] grid, int i, int j, boolean[][] visited, int val) {
		// 4조건체크해서 재귀적으로 호출
//		1. 마이너스 좌표체크 2. m*n 범위체크 3*3 i= 0,1,2 3. grid[x][y] 값체크(문제제시값)
		if(i<0 || j<0 || i >= m || j >= n || grid[i][j] ==0 || visited[i][j]) 
			return;
//      2. dfs 
		visited[i][j] = true; // 00
		System.out.println("===11====");
		boolprint(visited);
		val = val + grid[i][j]; // 8= 0+8, 9 = 8+1
		totalVal = Math.max(totalVal, val);
		
		for(int[] dir : dirs) {
			dfs(grid, i+dir[0],j+dir[1], visited, val); //4 dir
		}
		visited[i][j] =false;
		System.out.println("===22====");
		boolprint(visited);
	}

	public static void boolprint(boolean[][] arr2) {
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				System.out.print(" [" + i + "][" + j + "] " + arr2[i][j]);
			}
			System.out.println("");
		}
	}
	
	
	
	public static void print(int[][] arr2) {
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				System.out.print(" a[" + i + "][" + j + "] " + arr2[i][j]);
			}
			System.out.println("");
		}
	}

}
