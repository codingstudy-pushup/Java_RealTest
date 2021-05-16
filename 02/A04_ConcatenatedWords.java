package realTest02;

import java.util.*;

public class A04_ConcatenatedWords {

	public static void main(String[] args) {
		String[] str = { "cat", "cats", "catdogcats", "dog", "dogcatsdog", };

		A04_ConcatenatedWords a = new A04_ConcatenatedWords();
		System.out.println(a.solve(str));
	}

	public List<String> solve(String[] words) {
		List<String> result = new ArrayList<>();
		Set<String> set = new HashSet<>();
//		Arrays.sort(words, new Comparator<String>() {
//			public int compare(String s1, String s2) {
//				return s1.length() - s2.length();
//			}
//		});
		Arrays.sort(words, (a, b) -> a.length() - b.length());

		for (int i = 0; i < words.length; i++) {
			if (makeWord(words[i], set)) {
				System.out.println("word[" + i + "] " + words[i] + " set " + set);
				System.out.println("");
				result.add(words[i]);
			}
			set.add(words[i]);
		}
		return result;
	}

	private static boolean makeWord(String word, Set<String> dict) {
		if (dict.isEmpty())
			return false;
		boolean[] dp = new boolean[word.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= word.length(); i++) {
			for (int j = 0; j < i; j++) {
				System.out.println("11 dp[" + j + "] " + dp[j]);
				if (!dp[j]) {
					System.out.println("22 dp[" + j + "] " + dp[j]);
					continue;
				}
				System.out.println("word.substring(" + j + " " + i + " ): " + word.substring(j, i));
				if (dict.contains(word.substring(j, i))) {

					dp[i] = true;
					break;
				}
			}
		}
		return dp[word.length()];
	}
}
