package programmers;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
//우선순위 큐 최고
public class P12927_야근지수 {

	public static void main(String[] args) throws IOException {
		System.out.println(solution(4, new int[] {4,3,3}));
//		System.out.println(solution(1, new int[] {2,1,2}));
//		System.out.println(solution(3, new int[] {1,1}));
	}
	
	 public static long solution(int n, int[] works) {
	        long answer = 0;
	        
	        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	        
	        for(int w : works) {
	        	pq.add(w);
	        }
	        
	        for(int i=0;i<n;i++) {
	        	int top = pq.poll();
	        	
	        	if(top>0) {
	        		pq.add(top-1);
	        	}
	        	if(top == 0) return 0;
	        }
	        
	        while(!pq.isEmpty()) {
	        	int num = pq.poll();
	        	
	        	answer+= Math.pow(num, 2);
	        	
	        }
	        
	        return answer;
    }

}
