package realTest02;

public class A01_RobotBoundInCircle {

	public static void main(String[] args) {

		String command = "GGLG";
		System.out.println(solve(command));
	}

	public static boolean solve(String comm) {
		if (comm.length() == 0)
			return false;
		int x = 0;
		int y = 0;
		String dir = "N";

		for (char ch : comm.toCharArray()) {
			if (ch == 'G') {
				if (dir.equals("N"))
					y += 1;
				else if (dir.equals("S"))
					y -= 1;
				else if (dir.equals("E"))
					x += 1;
				else if (dir.equals("W"))
					x -= 1;
			} else if (ch == 'L') {
				if (dir.equals("N"))
					dir = "W";
				else if (dir.equals("W"))
					dir = "S";
				else if (dir.equals("S"))
					dir = "E";
				else
					dir = "N";
			} else if (ch == 'R') {
				if (dir.equals("N"))
					dir = "E";
				else if (dir.equals("E"))
					dir = "S";
				else if (dir.equals("S"))
					dir = "W";
				else
					dir = "N";
			}
		}
		if (x == 0 && y == 0)
			return true;
		if (dir.equals("N"))
			return false;
		return true;
	}

	public static boolean solve2(String command) {
		// N = 0, E = 1, S = 2, W = 3
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
