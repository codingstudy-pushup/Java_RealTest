package realTest04;

// Time Complexity(n2d)
// Space Complexity(nd)
// Where n is number of jobs

public class A03_MinJobsch {

	public static void main(String[] args) {
//		int[] jobDifficulty = { 6, 5, 4, 3, 2, 1 };
//		int d = 2;

		int[] jobDifficulty = { 7, 1, 7, 1, 7, 1 };
		int d = 3;

//		int[] jobDifficulty = { 1,1, 1 };
//		int d = 3;
		System.out.println(minDifficulty(jobDifficulty, d));
	}

	public static int minDifficulty(int[] jobDifficulty, int day) {

		int n = jobDifficulty.length;
		if (n < day)return -1;
		int[][] dp = new int[day][n];
		dp[0][0] = jobDifficulty[0];

		for (int i = 1; i < n; i++) {
			dp[0][i] = Math.max(jobDifficulty[i], dp[0][i - 1]);
			System.out.println("dp[" + 0 + "][" + i + "]" + dp[0][i]);
		}

		for (int d = 1; d < day; d++) {
			for (int len = d; len < n; len++) {
				int localMax = jobDifficulty[len];
				dp[d][len] = Integer.MAX_VALUE;

				for (int schedule = len; schedule >= d; schedule--) {
					//System.out.println("schedule: "+schedule);
					//System.out.println("jobDifficulty[" + schedule + "] " + jobDifficulty[schedule]);
					localMax = Math.max(localMax, jobDifficulty[schedule]);
					//System.out.println("dp["+d+"]["+len+"]"+dp[d][len]);
					//System.out.println("dp["+(d-1)+"]["+(schedule - 1)+"]"+dp[d - 1][schedule - 1]+"+"+localMax
					//		+"="+(dp[d - 1][schedule - 1] + localMax));
					dp[d][len] = Math.min(dp[d][len], dp[d - 1][schedule - 1] + localMax);
					//System.out.println("dp["+d+"]["+len+"]"+dp[d][len]);
				}
				//System.out.println("======schedule========");
				print(dp);
			}
			System.out.println("======len========");
		}
		return dp[day - 1][n - 1];
	}

	public static void print(int[][] arr2) {
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				System.out.print("[" + i + "][" + j + "] " + arr2[i][j]);
			}
			System.out.println("");
		}
	}
}
