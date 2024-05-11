import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2240_자두나무 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		int [] tree = new int[t+1];
		//  몇번째인가 / 몇번 카운트/ 지금 어디있는가 /
		int [][][] dp = new int[1001][31][3]; // 1000 30 2
		
		int ans = Integer.MIN_VALUE;
		
		for(int i=1;i<=t;i++) {
			tree[i] = Integer.parseInt(br.readLine());
				
		}
		
		//자두는 1번 나무 아래서 시작
		dp[1][0][1] = tree[1] == 1 ? 1 : 0;
		  dp[1][1][2] = tree[1] == 2 ? 1 : 0;

		  for (int i = 2; i <= t; i++) {
		    for (int j = 0; j <= w; j++) {
		      if (j > 0) {
		        // 자두가 1번에 떨어질때
		        if (tree[i] == 1) {
		          // i-1번째일때 2번에서 이동해서 먹거나
		          // i-1번째일때 1번에서 그대로 있어서 먹거나
		          dp[i][j][1] = Math.max(dp[i - 1][j - 1][2], dp[i - 1][j][1]) + 1;

		          // i-1번째일때 2번에서 그대로 있어서 못먹거나
		          // i-1번째일때 1번에서 옮겨서 못먹거나
		          dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i - 1][j - 1][1]);
		        } else {
		          // i-1번째일때 2번에서 그대로 있어서 한개먹거나
		          // i-1번째일때 1번에서 움직여서 한개 먹거나
		          dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i - 1][j - 1][1]) + 1;

		          // i-1번째일때 1번에서 그대로 있어서 못 먹거나
		          // i-1번째일때 2번에서 옮겨서 못먹거나
		          dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2]);
		        }
		      } else {
		          
		        // 계속 안움직일때 (j가 0보다 작아지는것 방지)
		        if (tree[i] == 1) {
		          dp[i][0][1]=dp[i-1][0][1]+1;
		          dp[i][0][2]=dp[i-1][0][2];
		        } else {
		          dp[i][0][1]=dp[i-1][0][1];
		          dp[i][0][2]=dp[i-1][0][2]+1;
		        }
		      }
		    }
		  }
		
		for(int i=0;i<=w;i++) {
			ans = Math.max(ans, Math.max(dp[t][i][1], dp[t][i][2]));
		}
		System.out.println(ans);
		
		
	}

}
