package realTest02;

public class A05_LongestPalindromSubstring {

	public static void main(String[] args) {
		A05_LongestPalindromSubstring a = new A05_LongestPalindromSubstring();
//		String s = "bananas";
		String s = "bana";
		System.out.println(a.solve(s));
	}

	public String solve(String s) {
		// 1. ds
		int n = s.length(); // 4
		boolean[][] dp = new boolean[n][n];
		String result = null;

		// 2. for
		for (int i = 0; i < n; i++) {
			for (int j = i; j >= 0; j--) {
				System.out.println("dp[" + j + "][" + i + "] " + dp[j][i]);
			    if(s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
				   dp[j][i] = true;
				   
				   if(result ==null || i-j+1 > result.length()) {
					   result= s.substring(j, i+1);
				   }
				}
			}
			System.out.println("");
		}
		return result;

	}
	

	public static void boolprint(boolean[][] arr2) {
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				System.out.print("[" + i + "][" + j + "]" + arr2[i][j]);
			}
			System.out.println("");
		}
	}

}
