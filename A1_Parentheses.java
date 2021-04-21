package realtest01;

public class A1_Parentheses {

	public static void main(String[] args) {

		String s = "(()())(())";
		System.out.println(solve(s));
	}

	public static String solve(String S) {

		StringBuilder sb = new StringBuilder();
		int open = 0, close = 0, start = 0;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '(') {
				open++;
			} else if (S.charAt(i) == ')') {
				close++;
			}
			if (open == close) {
				sb.append(S.substring(start + 1, i));
				start = i + 1;
			}
		}
		return sb.toString();
	}
}
