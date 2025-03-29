import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1189_컴백홈 {
    static int r,c,k;
    static char[][] map;
    static boolean[][] visit;
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    static int ans=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visit = new boolean[r][c];

        for(int i=0;i<r;i++){
            String s = br.readLine();
            for(int j=0;j<c;j++){
                map[i][j] =  s.charAt(j);

            }
        }

        visit[r-1][0] = true; // 이걸 false로 해서 자꾸 틀렸습니다 ... ;; 실수 오바
        dfs(new Node(r-1,0),1);
        System.out.println(ans);
    }


    static void dfs(Node now, int depth){
            //if now가 0,c면   ans++;
        if(now.x==0 && now.y == c-1){
            if(depth == k){
                ans++;
            }
        }
        for(int i=0;i<4;i++){
            int nx = now.x + dx[i];
            int ny = now.y + dy[i];
            if(nx<0||nx>=r||ny<0||ny>=c){
                continue;
            }
            if(!visit[nx][ny] && map[nx][ny] != 'T'){
                visit[nx][ny] = true;
                dfs(new Node(nx,ny),depth+1);
                visit[nx][ny] = false;
            }

        }

    }



}
class Node{
    int x; int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
