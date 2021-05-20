package realTest03;

public class A01_BreakPalindrom {

	public static void main(String[] args) {
//		String str = "abccba";
//		String str = "baab";
//		String str = "bnb";
		String str = "a";
		System.out.println(solve(str));

	}

	public static String solve(String s) {
		if (s.length() <= 1)
			return "";
		char[] arr = s.toCharArray();

		for (int i = 0; i < arr.length / 2; i++) {
			if (arr[i] != 'a') { 
				arr[i] = 'a';
				return String.valueOf(arr);
			}
		}
		arr[arr.length - 1] = 'b';
		return String.valueOf(arr);
	}

}
