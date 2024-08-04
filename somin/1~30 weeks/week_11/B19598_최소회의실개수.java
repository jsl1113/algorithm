package BOJ.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * 우선순위 큐.. 가 뭔지 몰라서 헤맸다
 * 그냥 큐로 해결하려고 했는데 시간초과 or 틀렸습니다 나옴 ㅠ
 * 
 * 우선순위 큐는 peek 값이 숫자가 큰 값인가?
 * 검색해서 찾아봤는데 너무 헷갈린다.
 */
public class B19598_최소회의실개수 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<int []> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			pq.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		
		PriorityQueue<Integer> room = new PriorityQueue<Integer>();
		room.add(pq.poll()[1]);
		
		while(!pq.isEmpty()) {
			
			
			int time[]  = pq.poll();
			if(room.peek()<=time[0]) {
				room.poll();
			}
			room.add(time[1]);
			
		}
		System.out.println(room.size());
		
		
	}
	

}
