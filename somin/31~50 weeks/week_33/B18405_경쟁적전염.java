import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * node 클래스 선언하는 부분.. 어려웠다
 */
public class B18405_경쟁적전염 {

	static int n,k,s,x,y;
    static int map[][];
    static boolean visited[][];
    static int dx[]= {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        map = new int[n][n];
        visited = new boolean[n][n];
        for(int i=0; i<n; i++) {
            String[] mm = br.readLine().split(" ");
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(mm[j]);
                if(map[i][j]!=0) {
                    visited[i][j]=true;
                    pq.add(new Node(i,j,0,map[i][j]));
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        
        bfs();
	}
	
	public static void bfs() {
		
        while(!pq.isEmpty()) {
            Node now= pq.poll();
            
            if(now.time>s) {  
                System.out.println(0);
                return;
            }
            
            if(now.x==x-1 && now.y==y-1 && map[now.x][now.y]!=0) {
                System.out.println(now.virus_num);
                return;
            }
            
            for(int i=0;i<4;i++) {
                int nx = now.x+dx[i];
                int ny =now.y+dy[i];
                
                if(nx<0 || nx>=n || ny<0 || ny>=n || visited[nx][ny]) {
                	continue;
                }
                visited[nx][ny] = true;
                map[nx][ny]=now.virus_num;
                pq.add(new Node(nx,ny,now.time+1,now.virus_num));
            }
        }
    }

}
//
class Node implements Comparable<Node>{
    int x,y,time,virus_num;

    Node(int x, int y, int time, int virus_num){
        this.x=x;
        this.y=y;
        this.time=time;
        this.virus_num = virus_num;
    }
    public int compareTo(Node o) {  
        if(this.time<o.time || this.time>o.time) {
            return this.time-o.time;    
           
        }
        else { //바이러스 작은것부터
            return this.virus_num - o.virus_num;
        }
    }
}
