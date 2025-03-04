import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
 뒤에서부터 값을 빼고 더해주니까 답이 쉽게 나왔다.
 long 자료형을 ans에 주지 않아서 틀렸습니다가 나왔다.
 */
public class B11501_주식 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            int[] stock = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                stock[j] = Integer.parseInt(st.nextToken());
            }

            int ans = 0;
            int now = stock[n-1];
            for(int j=n-1;j>=0;j--){
                if(now < stock[j]){
                    now = stock[j];
                }
                else if(now > stock[j]){
                    ans += now-stock[j];
                }
            }

            System.out.println(ans);
        }

    }
}
