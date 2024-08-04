import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B13335_트럭 {

	// n = 트럭 개수
	// w = 다리 길이 (트럭이 다리위에 최대 w개 올 수 있다)
	// L = 트럭 무게 최대 하중
	// arr = 순서대로 트럭의 무게
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		
		int arr[] = new int[n];
		Queue<Integer> que = new LinkedList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			que.add(arr[i]);
		}
		
		//다리 위에 있는 차들
		Queue<Integer> bridge = new LinkedList<Integer>();
		for(int i=0;i<w;i++) {
			bridge.add(0);
		}
		
		int time =0;
		int weight = 0;
		
		while(!bridge.isEmpty()) {
			
			int now = bridge.poll();
			weight -= now;
			
			time++;
			
			//큐에서 
			if(!que.isEmpty()) {
				// 무게 제한 체크
				int peek = que.peek();
				if(peek + weight <=L) {
					bridge.add(que.poll());
					weight+=peek;
				}else {//무게가 초과면
					bridge.add(0);
				}
			}
			
			
		}
		
		
		System.out.println(time);
		
		
		 
	}

}
