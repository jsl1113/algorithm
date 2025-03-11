import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B14891_톱니바퀴 {

    static boolean[] rotate = new boolean[3];
    static String[] s1,s2,s3,s4;

    static String[][] arr  = new String[4][8];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;//= new StringTokenizer(br.readLine());

        s1 = (br.readLine()).split("");
        s2 = (br.readLine()).split("");
        s3 = (br.readLine()).split("");
        s4 = (br.readLine()).split("");

        arr[0] = s1;arr[1] = s2;arr[2] = s3;arr[3] = s4;

        int k =  Integer.parseInt(br.readLine());
        for(int i=0;i<k;i++){
            check();

            st= new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken()); //1: 시계 -1:반시계

            turn(num-1,direction);
            direction = direction ==-1 ? 1:-1;
            toLeft(num-1,direction);
            toRight(num-1,direction);
        }
        System.out.println(score());
    }

    //각 바퀴 사이의 극이 같은지 다른지 체크하는 함수
    static void check(){
        //1번과 2번 사이
        if(arr[0][2].equals(arr[1][6])){
            rotate[0] = false;
        }else{
            rotate[0] = true;
        }
        //2번과 3번 사이
        if(arr[1][2].equals(arr[2][6])){
            rotate[1] = false;
        }else{
            rotate[1] = true;
        }
        //3번과 4번 사이
        if(arr[2][2].equals(arr[3][6])){
            rotate[2] = false;
        }else{
            rotate[2] = true;
        }
    }

    //네 톱니바퀴의 점수를 구하는 함수
    static int score(){
        int sum = 0;
        if(arr[0][0].equals("1")){
            sum+=1;
        }
        if(arr[1][0].equals("1")){
            sum+=2;
        }
        if(arr[2][0].equals("1")){
            sum+=4;
        }
        if(arr[3][0].equals("1")){
            sum+=8;
        }
        return sum;
    }

    /*
     만약 3번이 돌았다면
     3-1 = 2가 now에 들어가게 됨
     1과 2사이는 rotate[0]
     2와 3사이는 rotate[1]
     3과 4사이는 rotate[2]
     즉, 왼쪽으로 가는 기준이면
     now-1의 rotate를 확인하면 된다.
     */
    static void  toLeft(int now, int dir){
        while(now>0){
            if(rotate[now-1]){ //사이의 극이 다르다면
                turn(now-1,dir);
                dir = dir ==-1 ? 1 : -1;
            }else {
                break; //회전하지 않았으면 더이상 확인하지 않아도 됨
            }
            now--;
        }
    }
    /*
     만약 3번이 돌았다면
     3-1 = 2가 now에 들어가게 됨
     즉, 오른쪽으로 가는 기준이면
     now의 rotate를 확인하면 된다.
     */
    static void  toRight(int now, int dir){
        while(now<3){
            if(rotate[now]){ //사이의 극이 다르다면
                turn(now+1,dir);
                dir = dir ==-1 ? 1 : -1;
            }else {
                break; //회전하지 않았으면 더이상 확인하지 않아도 됨
            }
            now++;
        }
    }

    static void turn(int num, int dir){
        String f = arr[num][0];
        String e = arr[num][7];

        //시계방향이면 오른쪽으로
        if(dir == 1){
            for(int i=7;i>=1;i--){
                arr[num][i] = arr[num][i-1];
            }
            arr[num][0]=e;
        }else{ //반시계
            for(int i=0;i<7;i++){
                arr[num][i] = arr[num][i+1];
            }
            arr[num][7]=f;
        }
    }

}
