package realTest03;

public class A03_SlowestKey {

	public static void main(String[] args) {

		int[] releaseTimes = { 9, 29, 49, 50 };
		String keysPressed = "cbcd";
		System.out.println(solve(releaseTimes, keysPressed));
	}

	public static char solve(int[] time, String key) {
		int n = time.length;
		int max = time[0];
		char slowChar = key.charAt(0);
		
		for (int i = 1; i < n; i++) {
			int diff = time[i] - time[i - 1];

			if (diff > max || (diff == max && key.charAt(i) > slowChar)) {
				max = diff;
				slowChar = key.charAt(i);
			}
		}
		return slowChar;
	}
}
