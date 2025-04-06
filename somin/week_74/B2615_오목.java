import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2615_오목 {

    static int[][] map = new int[19][19];
    static boolean[][] visit = new boolean[19][19];
    static int[] dx = {1,1,0,1};
    static int[] dy = {0,1,1,-1};
    //왼쪽 아래 방향으로 가는 것도 필요하다. (1, -1)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;//= new StringTokenizer(br.readLine());

        for(int i=0;i<19;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<19;j++){
                map[i][j] = Integer.parseInt(st.nextToken());


            }
        }

        //흑 =1 백 = 2 비김 = 0
        //제일 왼쪽 위의 r,c를 출력
        for(int i=0;i<19;i++){
            for(int j=0;j<19;j++){
                if(map[i][j]!=0){
                    for(int k=0;k<4;k++){
                        if(check(i,j,map[i][j],k)){
                            //제일 왼쪽에 있는 돌이 출력되어야 한다.!!!!!!
                            if(k==3){
                                System.out.println(map[i][j]);
                                System.out.println((i+4+1)+" "+(j-4+1));
                            }else{
                                System.out.println(map[i][j]);
                                System.out.println((i+1)+" "+(j+1));
                            }
                            return;
                        }
                    }
                }
            }
        }

        System.out.println(0);


    }

    static boolean check(int x, int y, int color, int dir){
        //5개 채우면 ok 하지만 6개는 ㄴㄴ
//        System.out.println("start : "+x +" "+y+" "+color+" !");

        int cnt =1;
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        while(cnt<5 && nx>=0 && nx<19&& ny>=0 && ny<19&&map[nx][ny] == color){
//            System.out.println(cnt+" !!cnt");
            cnt++;
            nx += dx[dir];
            ny += dy[dir];
        }

        if(cnt == 5){
            // 이전 돌
            nx = x - dx[dir];
            ny = y - dy[dir];

            if(nx>=0 && nx<19&& ny>=0 && ny<19&&map[nx][ny] == color){
                return false;
            }
            //다음 돌
            nx = x + 5* dx[dir];
            ny = y + 5* dy[dir];
            if(nx>=0 && nx<19&& ny>=0 && ny<19&&map[nx][ny] == color){
                return false;
            }
            return true;
        }
        return false;

    }



}
