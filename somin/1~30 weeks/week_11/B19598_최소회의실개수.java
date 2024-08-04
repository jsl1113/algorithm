package BOJ.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * �켱���� ť.. �� ���� ���� ��̴�
 * �׳� ť�� �ذ��Ϸ��� �ߴµ� �ð��ʰ� or Ʋ�Ƚ��ϴ� ���� ��
 * 
 * �켱���� ť�� peek ���� ���ڰ� ū ���ΰ�?
 * �˻��ؼ� ã�ƺôµ� �ʹ� �򰥸���.
 */
public class B19598_�ּ�ȸ�ǽǰ��� {

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
