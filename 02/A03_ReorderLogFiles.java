package realTest02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class A03_ReorderLogFiles {

	public static void main(String[] args) {
		String[] input = { 
				"dig1 8 1 5 1", 
				"let1 art can", 
				"dig1 3 6", 
				"let2 own kit dig", 
				"let3 art zero" };

		A03_ReorderLogFiles a = new A03_ReorderLogFiles();
		String[] result = a.reorderLogFiles_1(input);
		for (String s : result)
			System.out.println("s: " + s);
	}

	public String[] reorderLogFiles_1(String[] logs) {
		Arrays.sort(logs, (s1, s2) -> {
			String[] split1 = s1.split(" ", 2);
			String[] split2 = s2.split(" ", 2);

			boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
			boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
			System.out.println("split1[1].charAt(0):" + split1[1].charAt(0));
			System.out.println("split2[1].charAt(0):" + split2[1].charAt(0));

			if (!isDigit1 && !isDigit2) {
				// 1. 모두 문자
				int comp = split1[1].compareTo(split2[1]);
				if (comp == 0)
					return split1[0].compareTo(split2[0]);
				else
					return comp;
			} else if (isDigit1 && isDigit2) {
				// 2. 모두 숫자
				return 0;
			} else if (isDigit1 && !isDigit2) {
				// 3. 첫번째는 숫자, 두번째는 문자
				return 1;
			} else {
				// 4. 첫번째는 문자, 두번째는 숫자.
				return -1;
			}
		});
		return logs;
	}
}
