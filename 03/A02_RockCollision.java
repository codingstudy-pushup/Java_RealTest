package realTest03;

import java.util.*;

public class A02_RockCollision {

	public static void main(String[] args) {
//		int[] rock = { 5, 10, -5 };
		int[] rock = { -3,-1,1,2};
		int[] result = solve(rock);
		for(int i:result)
			System.out.println("i "+i);

	}

	public static int[] solve(int[] rock) {
		Stack<Integer> s = new Stack<>();
		for (int i : rock) {
			if (0 < i ) {
				s.push(i);
 			} else {
				while (!s.isEmpty() && s.peek() > 0 && s.peek() < Math.abs(i)) {
					s.pop();
				}
				if (s.isEmpty() || s.peek() < 0) {
					s.push(i);
				} else if (i + s.peek() == 0) {
					s.pop(); 
				}
			}
		}
		int[] result = new int[s.size()];
		for (int i = result.length - 1; i >= 0; i--) {
			result[i] = s.pop();
		}
		return result;
	}

}
