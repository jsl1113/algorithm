import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//n =16 최대라 bfs가 가능할 것 같았다. dp로는 감이 잘 안온다.
public class B17070_파이프옮기기1 {

	static int n;
	static int[][] map;
	static int ans=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		n =Integer.parseInt(br.readLine());

		map = new int[n+1][n+1];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i+1][j+1] = Integer.parseInt(st.nextToken());
			}
		}
		
		//처음 out 체크
		if(map[1][3] == 1 || map[n][n]==1) {
			System.out.println(0);
			return;
		}
		bfs();
		System.out.println(ans);
	}
	
	
	static void bfs() {
		Queue<Pipe> queue = new LinkedList<>();
		queue.add(new Pipe(1, 2, 1));
		
		while(!queue.isEmpty()) {
			Pipe now = queue.poll();
			
			//check
			if(now.x == n && now.y==n) {
				ans++;
				continue;
			}
			
			//가로
			if(now.status == 1) {
				//오른쪽
				if(right(now.x, now.y) ) {
					queue.add(new Pipe(now.x, now.y+1, 1));
				}
				//대각
				if(diagonal(now.x, now.y)) {
					queue.add(new Pipe(now.x+1, now.y+1, 3));
				}
				
			}else if(now.status ==2) { //세로
				//아래
				if(down(now.x, now.y) ) {
					queue.add(new Pipe(now.x+1, now.y, 2));
				}
				//대각
				if(diagonal(now.x, now.y)) {
					queue.add(new Pipe(now.x+1, now.y+1, 3));
				}
				
			}else { //대각
				//오른쪽
				if(right(now.x, now.y) ) {
					queue.add(new Pipe(now.x, now.y+1, 1));
				}
				//아래
				if(down(now.x, now.y) ) {
					queue.add(new Pipe(now.x+1, now.y, 2));
				}
				//대각
				if(diagonal(now.x, now.y)) {
					queue.add(new Pipe(now.x+1, now.y+1, 3));
				}
			}
			
		}
		
	}
	
	static boolean right(int x, int y) {
		if(y+1<=n && map[x][y+1]!=1) {
			return true;
		}
		return false;
	}
	static boolean down(int x, int y) {
		if(x+1<=n && map[x+1][y]!=1) {
			return true;
		}
		return false;
	}
	static boolean diagonal(int x, int y) {
		if(x+1<=n && y+1<=n && map[x][y+1]!=1 
				&& map[x+1][y]!=1 && map[x+1][y+1]!=1) {
			return true;
		}
		return false;
	}
	
	static class Pipe{
		int x;
		int y;
		int status; //1 = 가로, 2 = 세로, 3 = 대각
		public Pipe(int x, int y, int status) {
			this.x = x;
			this.y = y;
			this.status = status;
		}
		
	}
	

}
