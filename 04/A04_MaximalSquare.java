package realTest04;

public class A04_MaximalSquare {

	public static void main(String[] args) {
		A04_MaximalSquare a = new A04_MaximalSquare();
//		char[][] matrix = {
//				{ '1', '0', '0', '1' }, 
//				{ '0', '1', '1', '1' }, 
//				{ '0', '1', '1', '1' },
//				{ '1', '0', '0', '0' } };
		
//		char[][] matrix = {
//				{ '1', '1', '1', '1' }, 
//				{ '0', '1', '1', '1' }, 
//				{ '0', '1', '1', '1' },
//				{ '1', '0', '0', '0' } };
		char[][] matrix = {
				{ '1', '1', '1', '1' }, 
				{ '1', '1', '1', '1' }, 
				{ '1', '1', '1', '1' },
				{ '1', '1', '1', '1' } };
		System.out.println(a.solve_dp(matrix));
	}

	public int solve_dp(char[][] matrix) {
		//1. ds
		int m = matrix.length, n = m > 0 ? matrix[0].length : 0;
		int[][] dp = new int[m + 1][n + 1];
		int maxSquare = 0;
		
		//2. for,while
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					int min = Math.min(dp[i][j - 1], dp[i - 1][j]);
					dp[i][j] = Math.min(min, dp[i - 1][j - 1]) + 1;
					System.out.println("===dp======");
					print(dp);
					maxSquare = Math.max(maxSquare, dp[i][j]);
				}
			}
			System.out.println("===22 dp======");
			print(dp);
		}
		return maxSquare * maxSquare;
	}

	void print(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}
}
