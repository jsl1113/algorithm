package BOJ;
/*
 * ó���� n�� ������ 3������ ���� 4�̻��� ���� ������ ¥�� �������ߴ�.
 * �ִ� 3���̱� ������ 1��,2��,3���� ��찡 �� ���� ������ �����ؾ��ϳ�? -> �ƴ�
 * �׳� 3���� ���� M�� 3�̻��̱⶧���� true�� ġŲ�� ��ȣ�� �� �ִ밪�� ���� ����ϸ� �� ��.
 * ������ �ʹ� �����ߴ� ... => ����!
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16439_ġŲġŲġŲ {
	//n : �� ȸ�� ��
	//m : ġŲ ���� ��
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
