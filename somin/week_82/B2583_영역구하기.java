import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2583_영역구하기 {

    static int n,m,k;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[m][n];
        visit = new boolean[m][n];

        for(int i=0;i<k;i++){
            st= new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int y=y1;y<y2;y++){
                for(int x=x1;x<x2;x++){
                    arr[y][x] = 1;
                }
            }


        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j] == 0 && !visit[i][j] ){
                    list.add(bfs(j,i));
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int l :list){
            System.out.print(l+" ");
        }

    }

    static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        visit[y][x] = true;

        int area = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cy = now[0];
            int cx = now[1];

            for (int k = 0; k < 4; k++) {
                int ny = cy + dy[k];
                int nx = cx + dx[k];

                if (ny < 0 || ny >= m || nx < 0 || nx >= n) continue;
                if (visit[ny][nx] || arr[ny][nx] == 1) continue;

                visit[ny][nx] = true;
                q.add(new int[]{ny, nx});
                area++;
            }
        }

        return area;
    }


}

