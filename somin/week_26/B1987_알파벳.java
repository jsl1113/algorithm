package BOJ.brute_force;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * ������ ����� ���� �ʰ�.. bfs�������� �˰� Ǯ�ٰ� ������ ���� �ȳ��� �˰��� �з��� ��...
 * dfs�� ���� �˰� �� ���� �߸� �ñ��� ��... �ٺ���.
 */
public class B1987_���ĺ� {

	static int r,c;
	static char [][] arr;
	static boolean [][] visit;
	static boolean alpa[] = new boolean[26];
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int ans = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new char[r][c];
		visit = new boolean[r][c];
		
		for(int i=0;i<r;i++) {
			String s = br.readLine();
			for(int j=0;j<c;j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		visit[0][0] = true;
		alpa[arr[0][0] - 65] = true;
		
		dfs(0, 0, 1);
		
		System.out.println(ans);
	}
	
	static void dfs(int x, int y , int cnt) {
		
		int count =0;
		for(int i=0;i<4;i++) {
			
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(check(nx, ny)  && !visit[nx][ny] && !alpa[arr[nx][ny]-65]) {
				visit[nx][ny] = true;
				alpa[arr[nx][ny]-65] = true;
				count++;
				
				dfs(nx, ny, cnt+1);
				visit[nx][ny] = false;
				alpa[arr[nx][ny]-65] = false;
				count--;
				
			}
			
		}
		
		if(count==0) {
			ans = Math.max(ans, cnt);
			return;
		}
		
	}
	
	static boolean check(int x,int y) {
		if(x>=0 && x<r && y>=0 && y<c)
			return true;
		else 
			return false;
	}
	
	
}
