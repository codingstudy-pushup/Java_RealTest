package realtest01;
import java.util.*;
public class A5_WordBreak {
	
	public static void main(String[] args) {
		A5_WordBreak a = new A5_WordBreak();

		String s = "inflearn";
		List<String> dict = new ArrayList<>();
		dict.add("f");
		dict.add("in");
		dict.add("learn");
		dict.add("ab");
		System.out.println(a.wordBreak_dp(s, dict));
	}
	
    public boolean wordBreak_dp(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
        	System.out.println("start i: "+i);
            for (int j = 0; j < i; j++) {
            	System.out.println("j: "+j+" i: "+i+" "+(s.substring(j, i))+"  dp["+j+"]: "+dp[j]);
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                	System.out.println("22 "+s.substring(j, i));
                	dp[i] = true;
                    System.out.println("dp[i]: "+i+" "+dp[i]);
                    break;
                }
              	
              }
            System.out.println();
        }
        System.out.println("dp[s.length()]: "+dp[s.length()]+" "+s.length());
        return dp[s.length()];
    }
}
