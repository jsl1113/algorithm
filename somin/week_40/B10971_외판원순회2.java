import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B10971_외판원순회2 {

	static int n;
	static int[][] map;
	static int[] ans;
	
	static boolean[] visit;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		ans = new int[n];
		for(int i=0;i<n;i++) {
			String s [] = (br.readLine()).split(" ");
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		
		for(int i=0;i<n;i++) {
			visit = new boolean[n];
			visit[i] = true;
			ans[0] = i;
			travel(1, i, 0);
		}
		System.out.println(min);
		
	}
	
	static void travel(int cnt, int now, int sum) {
		
		if(cnt == n) {
			
			if(map[now][ans[0]]!=0) { //이거 처리 안해줘서 틀림..
				sum += map[now][ans[0]];
				min = Math.min(min, sum);
			}
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(!visit[i] && map[now][i]!=0) {
				visit[now] = true;
				ans[cnt] = i;
				travel(cnt+1, i, sum+map[now][i]);
				visit[now] = false;
			}
		}
		
	}

}
