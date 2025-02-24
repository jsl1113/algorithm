import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 *  너무 감을 못잡겠어서 정답을 봤다.... 
 *  
 *  2차원 배열을 1차원으로 줄여주면 더 직관적으로 dfs를 짤 수 있다 (= 모든 부분함수 구하기)
 *  그리고 visit으로 false면 가로로 계산, true면 세로로 계산해서 
 *  모든 경우의 수로 종이조각의 합을 계산하고 최댓값을 저장한다.
 */
public class B14391_종이조각 {

	static int n,m;
	static int[] map;
	static boolean [] visit;
	
	static int ans = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n*m];
		visit = new boolean[n*m];
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<m;j++) {
				map[i*m+j] = s.charAt(j)-'0';
			}
			
		}
		
		dfs(0);
		System.out.println(ans);
	}

	//4 4 였을 때 모든 경우의 수를 다 구해준다.
	static void dfs(int cnt) {
		if(cnt == n*m) {
			solve();
			return;
		}
		
		//false면 가로로 계산
		visit[cnt] = false;
		dfs(cnt+1);
		
		//세로로 계산
		visit[cnt] = true;
		dfs(cnt+1);
		
	}
	
	static void solve() {
		int sum = 0;
		int tmp = 0;
		
		//가로 체크
		for(int i=0;i<n;i++) {
			tmp=0;
			for(int j=0;j<m;j++) {
				//false일 때
				if(!visit[i*m+j]) {
					tmp *=10;
					tmp += map[i*m+j];
					
				}else {
					sum+=tmp;
					tmp=0;
				}
				
			}
			sum+=tmp;
		}

		//세로 체크
		for(int j=0;j<m;j++) {
			tmp=0;
			for(int i=0;i<n;i++) {
				//true일 때
				if(visit[i*m+j]) {
					tmp*=10;
					tmp += map[i*m+j];
				}else {
					sum+=tmp;
					tmp=0;
				}
			}
			sum+=tmp;
		}
		
		ans = Math.max(sum, ans);
		
	}
	
}
