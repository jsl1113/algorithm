import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B15903_카드합체놀이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		PriorityQueue<Long> que = new PriorityQueue<Long>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			que.add((long) arr[i]);
		}
		
		int cnt=0;
		while(cnt<m) {
			long x = que.poll();
			long y = que.poll();
			
			long sum = x+y;
			que.add(sum);
			que.add(sum);
			
			cnt++;
		}
		

		long ans = 0;
		while(!que.isEmpty()) {
			ans += que.poll();
		}
		
		System.out.println(ans);
	}

}
