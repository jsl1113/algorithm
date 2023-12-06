import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14499_주사위굴리기 {
	
	static int n,m,x,y;
	static int[][] map;
	static int[] dice = new int[7];
	
	static int[] dy= {1,-1,0,0};
	static int[] dx = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		int k = Integer.parseInt(st.nextToken());
		map  = new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<k;i++) {
			int aa = Integer.parseInt(st.nextToken());
			
			Rolldice(aa-1);
			
		}
		
	}
	
	static void Rolldice(int d) {
		
		int nx = x + dx[d];
		int ny = y + dy[d];
		
		if(nx<0 || nx>=n || ny <0 ||ny>=m) {
			return;
		}
		dice(d);
		if(map[nx][ny]==0) {
			map[nx][ny] = dice[1];
		}else {
			dice[1] = map[nx][ny];
			map[nx][ny] = 0;
		}
		x = nx;
		y = ny;
		System.out.println(dice[6]);
		
	}
	
	static void dice(int d) {
		int d1,d2,d3,d4,d5,d6;
		d1 = dice[1];
		d2 = dice[2];
		d3 = dice[3];
		d4 = dice[4];
		d5 = dice[5];
		d6 = dice[6];
		
		switch (d) {
		case 0:
			dice[3] = d1;
			dice[6] = d3;
			dice[4] = d6;
			dice[1] = d4;
			break;
		case 1:
			dice[4] = d1;
			dice[1] = d3;
			dice[3] = d6;
			dice[6] = d4;
			break;
		case 2:
			dice[2] = d1;
			dice[6] = d2;
			dice[5] = d6;
			dice[1] = d5;
			break;
		case 3:
			dice[5] = d1;
			dice[6] = d5;
			dice[2] = d6;
			dice[1] = d2;
			break;

		default:
			break;
		}
		
		
		
	}
	
}
