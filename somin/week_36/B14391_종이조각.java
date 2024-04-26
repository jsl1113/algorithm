import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 *  �ʹ� ���� ����ھ ������ �ô�.... 
 *  
 *  2���� �迭�� 1�������� �ٿ��ָ� �� ���������� dfs�� © �� �ִ� (= ��� �κ��Լ� ���ϱ�)
 *  �׸��� visit���� false�� ���η� ���, true�� ���η� ����ؼ� 
 *  ��� ����� ���� ���������� ���� ����ϰ� �ִ��� �����Ѵ�.
 */
public class B14391_�������� {

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

	//4 4 ���� �� ��� ����� ���� �� �����ش�.
	static void dfs(int cnt) {
		if(cnt == n*m) {
			solve();
			return;
		}
		
		//false�� ���η� ���
		visit[cnt] = false;
		dfs(cnt+1);
		
		//���η� ���
		visit[cnt] = true;
		dfs(cnt+1);
		
	}
	
	static void solve() {
		int sum = 0;
		int tmp = 0;
		
		//���� üũ
		for(int i=0;i<n;i++) {
			tmp=0;
			for(int j=0;j<m;j++) {
				//false�� ��
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

		//���� üũ
		for(int j=0;j<m;j++) {
			tmp=0;
			for(int i=0;i<n;i++) {
				//true�� ��
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
