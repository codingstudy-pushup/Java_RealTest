package realTest02;

import java.util.*;

public class A04_ConcatenatedWords {

	public static void main(String[] args) {
		String[] str = { "cat", "cats", "catdogcats", "dog", "dogcatsdog", };

		A04_ConcatenatedWords a = new A04_ConcatenatedWords();
		System.out.println(a.solve(str));
	}

	public List<String> solve(String[] words) {
		// 1. ds
		List<String> result = new ArrayList<>();
		Set<String> set = new HashSet<>();

		// 길이 오름차순
		Arrays.sort(words, (a, b) -> a.length() - b.length());

		// 2. for, while
		for (int i = 0; i < words.length; i++) {
			// cat, dog..
			if (makeWord(words[i], set)) {
				result.add(words[i]);
			}
			set.add(words[i]);
		}
		return result;
	}

	private static boolean makeWord(String word, Set<String> set) {

		if (set.isEmpty())
			return false;
		boolean[] dp = new boolean[word.length() + 1];
		dp[0] = true;

		for (int i = 1; i <= word.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && set.contains(word.substring(j, i))) {
					System.out.println("11 dp["+j+"] " + dp[j]);
					System.out.println("word.substring(" + j + " " + i + ") " + word.substring(j, i));
					dp[i] = true;
					break;
				}

			}
		}
		return dp[word.length()];
	}
}
