import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B18430_무기공학 {

	static int n,m;
	static int map[][];
	static boolean[][] visit;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visit = new boolean[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		
		//2X2보다 작으면 0출력
		if(n<2 || m<2) {
			System.out.println(0);
			return;
		}
		
		dfs(0,0);
		System.out.println(ans);
		
	}
	
	private static void dfs(int idx, int sum){
        if(idx ==n*m){
            ans = Math.max(ans, sum);
            return;
        }
 
        int y = idx/m;
        int x = idx%m;
 
        if(!visit[y][x]){
        	// 1
            if(y+1<n && x-1>=0 && !visit[y+1][x] && !visit[y][x-1]){
                visit[y][x]=true;
                visit[y+1][x]=true;
                visit[y][x-1]=true;
                dfs(idx+1, sum+map[y+1][x]+map[y][x-1]+(map[y][x]*2));
                visit[y][x]=false;
                visit[y+1][x]=false;
                visit[y][x-1]=false;
            }
            //2
            if(y+1<n && x+1<m && !visit[y+1][x] && !visit[y][x+1]){
                visit[y][x]=true;
                visit[y+1][x]=true;
                visit[y][x+1]=true;
                dfs(idx+1, sum+map[y+1][x]+map[y][x+1]+(map[y][x]*2));
                visit[y][x]=false;
                visit[y+1][x]=false;
                visit[y][x+1]=false;
            }
            //3
            if(y-1>=0 && x-1>=0 && !visit[y-1][x] && !visit[y][x-1]){
                visit[y][x]=true;
                visit[y-1][x]=true;
                visit[y][x-1]=true;
                dfs(idx+1, sum+map[y-1][x]+map[y][x-1]+(map[y][x]*2));
                visit[y][x]=false;
                visit[y-1][x]=false;
                visit[y][x-1]=false;
            }
            //4
            if(y-1>=0 && x+1<m && !visit[y-1][x] && !visit[y][x+1]){
                visit[y][x]=true;
                visit[y-1][x]=true;
                visit[y][x+1]=true;
                dfs(idx+1, sum+map[y-1][x]+map[y][x+1]+(map[y][x]*2));
                visit[y][x]=false;
                visit[y-1][x]=false;
                visit[y][x+1]=false;
            }
        }
        dfs(idx+1, sum);
    }

}
