import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B5212_지구온난화 {

	static int r,c;
	static char[][] map;
	static char[][] ans;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		ans = new char[r][c];
		
		for(int i=0;i<r;i++) {
			String[] now = (br.readLine()).split("");
			for(int j=0;j<c;j++) {
				map[i][j] = now[j].charAt(0);
				ans[i][j] = '.';
			}
		}
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(map[i][j] == 'X') {
					solve(i, j);
				}
			}
		}
	
		//그래프 자르기
		StringBuilder sb = new StringBuilder();
		//x부터
		ArrayList<Integer> garo = new ArrayList<Integer>();
		boolean flag = false; // 처음
		for(int i=0;i<r;i++) {
			int notXcnt =0;
			for(int j=0;j<c;j++) {
				if(ans[i][j]!='X') {
					notXcnt++;
				}
			}
			if(notXcnt != c) { //다 비어있다.
				garo.add(i);
			}
		}
		ArrayList<Integer> sero = new ArrayList<Integer>();
		for(int j=0;j<c;j++) {
			int notXcnt =0;
			for(int i=0;i<r;i++) {
				if(ans[i][j]!='X') {
					notXcnt++;
				}
			}
			if(notXcnt != r) { //다 비어있다.
				sero.add(j);
			}
		}
		
		//자르기 시작 
		int start_g = garo.get(0);
		int end_g = garo.get(garo.size()-1);
		int start_s = sero.get(0);
		int end_s = sero.get(sero.size()-1);
		
		for(int i=start_g;i<=end_g;i++) {
			for(int j=start_s;j<=end_s;j++) {
				sb.append(ans[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void solve(int x, int y) {
		int cnt =0;
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			//범위바깥이면 바다로 친다.
			if(nx<0 || ny<0 ||nx>=r || ny >=c) {
				cnt++;
			}else {
				if(map[nx][ny] == '.') {
					cnt++;
				}
			}
		}
		
		if(cnt<3) {
			ans[x][y] = 'X';
		}
		
	}
}
