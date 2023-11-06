package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class RV_B19598_최소회의실개수 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] refer = new int[n][2];
		
				
		
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) {
					return o1[1] - o2[1];
				}else
					return o1[0] - o2[0];
				
			}

			
		});
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			refer[i][0] = a;
			refer[i][1] = b;
			pq.add(new int[] {a,b});
			
		}
//		System.out.println(Arrays.deepToString(refer));
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
