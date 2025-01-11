import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
//오랜만에 짜릿하게 한번에 맞춘 느낌이다..ㅠㅠ
public class B18428_감시피하기 {

	static int[][] map;
	static int n;
	static boolean flag = false;
	static boolean[][] visit ;
	static ArrayList<int[]> teacher = new ArrayList<int[]>();
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		visit = new boolean[n][n];
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				String s = st.nextToken();
				if(s.equals("S")) {
					map[i][j] = 1;
				}else if(s.equals("T")) {
					map[i][j] = 2;
					teacher.add(new int[] {i,j});
				}
			}
		}
		
		dfs(0);
		
		if(flag) {
			System.out.println("YES");
			
		}else {
			System.out.println("NO");
		}
		
		
	}

	static void dfs(int cnt) {
		if(flag) {
			//break
			return;
		}
		if(cnt == 3) {
			//체크
			if(isAvoid()) { //피하는 데 성공함.
				flag = true;
			}
			return;
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!visit[i][j] && map[i][j]==0) {
					//오브젝트 설정 3 해주기
					map[i][j] =3;
					visit[i][j] = true;
					dfs(cnt+1);
					map[i][j] =0;
					visit[i][j] = false;
				}
			}
		}
		
		
	}
	
	
	static boolean isAvoid() {
		//선생이 상하좌우 봤을 때 O전에 S를 발견하면 false
		for(int[] tea : teacher) {
			for(int k=0;k<4;k++) {
				int con =0;
				while(true) {
					con++;
					int nx = tea[0]+ dx[k]*con;
					int ny = tea[1]+ dy[k]*con;
					
					if(nx<0 || nx>=n || ny<0||ny>=n) { //범위
						break;
					}else {
						if(map[nx][ny]==3) { //장애물을 만났으면 out
							break;
						}else if(map[nx][ny]==1) {//학생을 만났다?
							return false;
						}
						//나머지의 경우 0이거나 2(선생)일 경우는 계속 전진
					}
				}
				
			}
		}
		
		return true;
	}
}
