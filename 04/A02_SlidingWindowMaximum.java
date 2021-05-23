package realTest04;

import java.util.ArrayDeque;
import java.util.Deque;

public class A02_SlidingWindowMaximum {
	
	public static void main(String[] args) {
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int  k = 3;
		int[] res =solve(nums, k);
		for(int i:res)
			System.out.println("i "+i);
	}
	public static int[] solve(int[] nums, int winSize) {		
		//1.ds
		if (nums == null || winSize <= 0) 
			return new int[0];
		int n = nums.length;
		int[] result = new int[n-winSize+1];// 6= 8-3+1
		int index = 0;
		Deque<Integer> q = new ArrayDeque<>();
		
		//2. for, while
		for (int i = 0; i < n; i++) {
			// 범위체크 범위를 벗어나면 제거 
			System.out.println("i: "+i);
			while (!q.isEmpty() && q.peek() < i - winSize + 1) {  // 3개를 넘게 채우면 제거 , 2 < 3-3+1, 2 < 4-3+1
				System.out.println(" aa "+q.peek()+" "+(i - winSize + 1));
				q.poll();
			}
			// 큰값을 찾기위하여 큐의 마지막 부분부터 비교하여 삭제
		
			while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
				System.out.println(" bb "+nums[q.peekLast()]+" "+nums[i]);
				q.pollLast();
			}
			
			q.offer(i);
			if (i >= winSize - 1) { // 3개이상 부터 채운다. 3 >= 3-1
				result[index++] = nums[q.peek()];
			}
		}
		return result;
	}

}
