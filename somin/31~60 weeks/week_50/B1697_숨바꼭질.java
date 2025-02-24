import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697_숨바꼭질 {

	static int n,k;
	static int[] arr = new int[100001];
	
	static Queue<Integer> que = new LinkedList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr[n] = 0;
		
		if(n == k) {
			System.out.println(0);
			return;
		}
		
		bfs();
		
		System.out.println(arr[k]);
	}
	
	
	static boolean check(int now) {
		if(now<0 || now>100000) {  //범위 잘 쓰기
			return false;
		}
		return true;
	}
	
	static void bfs() {
		
		que.add(n);
		while(!que.isEmpty()) {
			int now = que.poll();
			
			//n = 0일 경우 있기때문에 +1 먼저
			if(check(now+1) && arr[now+1] == 0) {
				que.add(now+1);
				arr[now+1] = arr[now]+1;
				
			}
			
			if(check(now*2) && arr[now*2] == 0) {
				que.add(now*2);
				arr[now*2] = arr[now]+1;
			}
			
			
			if(check(now-1) && arr[now-1] == 0) {
				que.add(now-1);
				arr[now-1] = arr[now]+1;
				
			}
			
			
		}
		
				
	}
}
