import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B13549_���ٲ���3 {

	static int n,k;
	static boolean[] visit = new boolean[100001];
	//visit�� �ٸ� ������� int�� �ʱⰪ 0���� �ϰ� Ǯ���µ� Ʋ�Ƚ��ϴ�. 
	//                   �Ƹ� arr�� 0���� ���� ���� �ʱⰪ�̶� ���Ƽ� �׷���
	static int ans=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		if(n==k) {
			System.out.println(0);
			return;
		}
		
		bfs();
		System.out.println(ans);
	}
	static void bfs() {
		
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {n,0});
		
		while(!que.isEmpty()) {
			int[] nn = que.poll();
			int now = nn[0];
			int time = nn[1];
			visit[now] = true;
			
			if(now == k) {
				ans = Math.min(ans, time);
			}
			
			if(isRight(now*2) && !visit[now*2] ) {
				que.add(new int[] {now*2,time});
			}
			
			if(isRight(now+1) && !visit[now+1]) {
				que.add(new int[] {now+1,time+1});
				
			}
			if(isRight(now-1) && !visit[now-1]) {
				que.add(new int[] {now-1,time+1});
			}
			
			
		}
		
		
		
	}
	
	static boolean isRight(int num) {
		if(num <0 || num > 100000) {
			return false;
		}
		return true;
	}

}
