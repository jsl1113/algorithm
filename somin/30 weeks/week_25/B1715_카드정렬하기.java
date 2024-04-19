import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B1715_카드정렬하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int i=0;i<n;i++) {
			pq.add(Integer.parseInt(br.readLine()));
			
		}
		
		int ans = 0;
		while(pq.size()>=2) {
			int x = pq.poll();
			int y = pq.poll();
			
			pq.add(x+y);
			ans += x+y;
		}
		
		System.out.println(ans);
	}
}
