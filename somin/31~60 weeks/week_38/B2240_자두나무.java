import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2240_�ڵγ��� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		int [] tree = new int[t+1];
		//  ���°�ΰ� / ��� ī��Ʈ/ ���� ����ִ°� /
		int [][][] dp = new int[1001][31][3]; // 1000 30 2
		
		int ans = Integer.MIN_VALUE;
		
		for(int i=1;i<=t;i++) {
			tree[i] = Integer.parseInt(br.readLine());
				
		}
		
		//�ڵδ� 1�� ���� �Ʒ��� ����
		dp[1][0][1] = tree[1] == 1 ? 1 : 0;
		  dp[1][1][2] = tree[1] == 2 ? 1 : 0;

		  for (int i = 2; i <= t; i++) {
		    for (int j = 0; j <= w; j++) {
		      if (j > 0) {
		        // �ڵΰ� 1���� ��������
		        if (tree[i] == 1) {
		          // i-1��°�϶� 2������ �̵��ؼ� �԰ų�
		          // i-1��°�϶� 1������ �״�� �־ �԰ų�
		          dp[i][j][1] = Math.max(dp[i - 1][j - 1][2], dp[i - 1][j][1]) + 1;

		          // i-1��°�϶� 2������ �״�� �־ ���԰ų�
		          // i-1��°�϶� 1������ �Űܼ� ���԰ų�
		          dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i - 1][j - 1][1]);
		        } else {
		          // i-1��°�϶� 2������ �״�� �־ �Ѱ��԰ų�
		          // i-1��°�϶� 1������ �������� �Ѱ� �԰ų�
		          dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i - 1][j - 1][1]) + 1;

		          // i-1��°�϶� 1������ �״�� �־ �� �԰ų�
		          // i-1��°�϶� 2������ �Űܼ� ���԰ų�
		          dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2]);
		        }
		      } else {
		          
		        // ��� �ȿ����϶� (j�� 0���� �۾����°� ����)
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
