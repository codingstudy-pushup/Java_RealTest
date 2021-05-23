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
		int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
		int[][] dp = new int[rows + 1][cols + 1];
		int maxsqlen = 0;
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
					System.out.println("===dp======");
					print(dp);
					maxsqlen = Math.max(maxsqlen, dp[i][j]);
				}
			}
			System.out.println("===22 dp======");
			print(dp);
		}
		return maxsqlen * maxsqlen;
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
