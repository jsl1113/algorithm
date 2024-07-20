import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1520_�������� {

	static int n,m;
	static int[][] map;
	static int[][] dp;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		dp = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1; //���� �� ������ ���� -1 ������ �� 0 �� �̻��� ī��Ʈ ����
			}
		}
		
		System.out.println(dfs(0, 0));
	}
	/*
	 * ���⼭ �ڷ����� int�� �Ͽ� �������������� �Ž��� �ö󰡴� ����� ���� ���� ����
	 * ����dfs�� �� �� �ְ� dp�� 0,0���� �ϰ� �;����� ����� �̻��� �� ������..
	 *             0,0���� ���������� �ϸ� �������� �������ϴ� ��찡 ���� +a
	 */
	static int dfs(int x, int y) {
		if(x==n-1 && y==m-1) {
			return 1;
		}

		if(dp[x][y] != -1) {
			return dp[x][y];
		}
		
		dp[x][y] = 0;
		for(int k=0;k<4;k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			
			if(nx>=0 && nx<n && ny>=0 && ny<m ) {
				if(map[x][y] > map[nx][ny]) {
					dp[x][y] += dfs(nx, ny);
				}
				
			}
		}
		
		return dp[x][y];
		
	}

}
