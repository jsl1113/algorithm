import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B3184_¾ç {
	
	static int r,c;
	static char[][] map;
	static boolean[][] visit;
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	static int ans_s=0, ans_w =0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		visit = new boolean[r][c];
		
		for(int i=0;i<r;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(!visit[i][j] && (map[i][j] == 'o' || map[i][j] == 'v')) {
					bfs(i,j);
				}
			}
		}
		System.out.println(ans_s + " "+ans_w);
		
	}
	static void bfs(int x, int y) {
		Queue<int[] > que = new LinkedList<int[]>();
		que.add(new int[] {x,y});
		visit[x][y] = true;
		
		int sheep =0;
		int wolf = 0;
		
		if(map[x][y]=='o') {
			sheep++;
		}else {
			wolf++;
		}
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			
			for(int k=0;k<4;k++) {
				int nx = now[0] + dx[k];
				int ny = now[1] + dy[k];
				
				if(nx>=0 && ny >=0 && nx<r && ny<c) {
					if(!visit[nx][ny] && map[nx][ny]!='#') {
						visit[nx][ny] = true;
						if(map[nx][ny]=='o') {
							sheep++;
						}else if(map[nx][ny]=='v'){
							wolf++;
						}
						que.add(new int[] {nx,ny});
					}
				}
			}
		}
		
		if(sheep>wolf) {
			ans_s += sheep;
		}else {
			ans_w += wolf;
		}
		
	}
}
