import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16987_계란으로계란치기 {

	static int n;
	static Egg[] eggs;
	static boolean[] visit;
	static int ans = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(br.readLine());
		visit = new boolean[n];
		eggs = new Egg[n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			eggs[i] = new Egg(s, w);
		}
		
	
		dfs(0, 0);
		System.out.println(ans);
		
	}
	
	static void dfs(int cnt, int now) {
		if(now==n || cnt == n-1 ) { //제일 오른쪽으로 왔을 때 out
			ans = Math.max(cnt, ans);
			return;
		}
		
		if(eggs[now].s>0) { //안깨져있고
			for(int i=0;i<n;i++) {
				int preCnt = cnt;
				if(eggs[i].s>0 && now !=i) { //안깨지고 본인스스로 아님
					//계란 깨기 
					eggs[now].s -= eggs[i].w;
					eggs[i].s -= eggs[now].w;
					
					if(eggs[now].s<=0) { //현재 계란 깨짐
						cnt++;
					}
					if(eggs[i].s<=0) { //상대 계란 깨짐
						cnt++;
					}
					
					dfs(cnt, now+1);
					
					//계란 복구 
					eggs[now].s += eggs[i].w;
					eggs[i].s += eggs[now].w;
					//count 초기화
					cnt = preCnt;
					
				}
			}
		}else { //지금 들고 있는 계란이 깨져있어
			dfs(cnt, now+1);
		}
	}

	static class Egg{
		int s;
		int w;
		
		Egg(int s, int w) {
			this.s = s;
			this.w = w;
		}
		
	}
}
