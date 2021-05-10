package realTest02;

public class A01_RobotBoundInCircle {

	public static void main(String[] args) {

		String command = "GGLG";
		System.out.println(solve(command));
	}

	public static boolean solve(String command) {
		// north = 0, east = 1, south = 2, west = 3
		int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int x = 0, y = 0;
		// direction
		int dir = 0;

		for (char i : command.toCharArray()) {
			if (i == 'G') {
				x += dirs[dir][0];
				y += dirs[dir][1];
			} else if (i == 'L') {
				dir = (dir + 3) % 4;
			} else if (i == 'R') {
				dir = (dir + 1) % 4;
			}
		}
		if (x == 0 && y == 0) {
			return true;
		}
		if (dir == 0) {
			return false;
		}
		return true;
	}
}
