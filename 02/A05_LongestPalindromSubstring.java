package realTest02;

public class A05_LongestPalindromSubstring {

	public static void main(String[] args) {
		A05_LongestPalindromSubstring a = new A05_LongestPalindromSubstring();
//		String s = "bananas";
		String s = "babad";
		System.out.println(a.longestPalindrome_dp(s));
	}

	public String longestPalindrome_dp(String s) {
		// 1. ds
		int n = s.length();
		String res = null;
		boolean[][] dp = new boolean[n][n];

		// 2. for
		for (int i = 0; i < n; i++) {
			for (int j = i; j >= 0; j--) {
				System.out.println("dp[" + j + "][" + i + "] " + dp[j][i]);
				if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
					dp[j][i] = true;
					System.out.println("222 dp[" + j + "][" + i + "] " + dp[j][i]);
					if (res == null || i - j + 1 > res.length()) {
						res = s.substring(j, i + 1);
					}
				}
			}
		}

		return res;
	}

}
