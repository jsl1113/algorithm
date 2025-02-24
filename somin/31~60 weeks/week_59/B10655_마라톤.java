import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//처음에 하나씩 빼고 계산하려다 시간초과가 뻔해서 dp마냥 규칙을 찾으려고 하니까 풀 수 있었다.
public class B10655_마라톤 {

	static int n;
	static Node[] checkpoints;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(br.readLine());
		checkpoints = new Node[n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			checkpoints[i] = new Node(x, y);
		}
			
		if(n==3) {
			calc(checkpoints[0], checkpoints[n-1]);
			return;
		}
		
		int sum = 0;
		for(int i=0;i<n-1;i++) {
			sum += calc(checkpoints[i], checkpoints[i+1]);
		}
		
		for(int i=1;i<=n-2;i++) {
			int now = sum + calc(checkpoints[i-1], checkpoints[i+1]) -(calc(checkpoints[i-1], checkpoints[i]) + calc(checkpoints[i+1], checkpoints[i]) );
			
			ans = Math.min(now, ans);
		}
		
		System.out.println(ans);
		
	}
	
	static int calc(Node prior, Node now) {
		int x = Math.abs(prior.x - now.x);
		int y = Math.abs(prior.y - now.y);
		
		return x+y;
	}
	
	
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}

}
