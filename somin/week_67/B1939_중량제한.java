import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
//�ϴ� �̺�Ž������ �𸣰� dfs�θ� Ǫ���ٰ� �ð��ʰ�. dfs�� �� ��̴�..
public class B1939_�߷����� {

	static int ans;
	static int one,two,s=0,e;
	static ArrayList<Bridge>[] lst;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		lst = new ArrayList[n+1];
		for(int i=0;i<=n;i++) lst[i] = new ArrayList<>();
		//A B C 
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			e = Math.max(e, c);
			
			lst[a].add(new Bridge(b, c));
			lst[b].add(new Bridge(a, c));
			
		}
		
		st = new StringTokenizer(br.readLine());
		
		one = Integer.parseInt(st.nextToken());
		two = Integer.parseInt(st.nextToken());
		// �ִ� �߷��� �̺�Ž��
		while(s<=e) {
			int mid = (s+e)/2;
			
			ans = -1;
			visit = new boolean[n+1];
			
			dfs(mid, one); 
			if(ans !=-1) { //�̵� ����
				s = mid+1;
			}else { //�Ұ���
				e = mid-1;
			}
		}

		System.out.println(e);
	}
	
	static void dfs(int w, int now) {
		
		if(now == two) {
			ans = now;
			return;
		}
		visit[now] = true;
		
		for(Bridge i : lst[now]) {
			if(!visit[i.to] && w <= i.weight) {
				dfs(w, i.to);
			}
		}
		
	}
	
	
	//��� ó�� Ŭ������ ���� Ǯ��
	static class Bridge{
		int to;
		int weight;
		public Bridge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
	}
	
}
