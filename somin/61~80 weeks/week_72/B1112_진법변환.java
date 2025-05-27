import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
못 푼 이유
1. 나머지가 음수일 때 몫 + 1, 나머지+|b| 하는데 이해가 안 갔다
2. 음수 / 양수 일 때의 경우를 생각을 안했다.
 */
public class B1112_진법변환 {

    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st= new StringTokenizer(br.readLine());

            long x =  Long.parseLong(st.nextToken());
            long b =  Long.parseLong(st.nextToken());

            if(x == 0){
                System.out.println(0);
                return;
            }

            //음수 / 양수 : 음수를 양수로 바꾸고 마지막에 -만 더해준다.
            boolean flag = true; // 양수
            if(x<0 && b>0){
                flag = false;
                x = Math.abs(x );
            }
            StringBuilder sb = new StringBuilder();
            //10진수 x를 b진법으로 바꾸는 방법
            while(x!=0){

                long rest = x%b;
                x = x/b;

                if(rest<0){ //몫 + 1 나머지+|b|
                    x+=1;
                    rest = rest+Math.abs(b);
                }
                sb.append(rest);
            }
            if(!flag){
                sb.append("-");
            }
            System.out.println(sb.reverse());
    }
}
