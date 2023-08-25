package BOJ;
/*
 * 처음에 n의 개수가 3이하인 경우와 4이상인 경우로 나눠서 짜는 생각을했다.
 * 최대 3개이기 때문에 1개,2개,3개인 경우가 다 따로 나눠서 생각해야하나? -> 아님
 * 그냥 3개를 집고 M이 3이상이기때문에 true인 치킨의 선호도 중 최대값을 더해 출력하면 된 것.
 * 생각이 너무 부족했다 ... => 복습!
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16439_치킨치킨치킨 {
	//n : 고리 회원 수
	//m : 치킨 종류 수
	static int n,m;
	static int [][] prefer;
	static int ans = 0;
	static boolean [] isVisited;

	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		prefer = new int[n][m];
		isVisited = new boolean[m];

		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<m;j++) {
				prefer[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);
		System.out.println(ans);

	}
	
	public static void dfs(int cnt, int x) {
		if(cnt==3) {
			int sum=0;
			for(int i=0;i<n;i++) {
				int max = 0;
				for(int j=0;j<m;j++) {
					if(isVisited[j]) {
						max = Math.max(max, prefer[i][j]);
					}
				}
				sum+=max;
			}
			ans = Math.max(ans, sum);
			return;
		}
		
		for(int i=x;i<m;i++) {
			if(!isVisited[i]) {
				isVisited[i]=true;
				dfs(cnt+1,i+1);
				isVisited[i]=false;
			}
		}
		
	}
}
