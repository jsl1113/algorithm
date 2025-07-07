import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1735_분수합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st= new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());


        if(b == d){
            int x = a+c;
            int y = b;
            int[] num = abb(x,y);
            System.out.println(num[0]+" "+num[1]);
            return;
        }

        int sum_a = a*d;
        int sum_c = c*b;

        int sum_ac = sum_a+sum_c;
        int sum_bd = b*d;

        int[] ans = abb(sum_ac,sum_bd);
        System.out.println(ans[0] + " "+ans[1]);
    }

    //최대공약수 구하기
    static int gcd(int a, int b){
        if(a%b==0){
            return b;
        }
        int r = a % b;

        return gcd(b,r);
    }

    static int[] abb(int a, int b){
        int[] ans = new int[2];
        int num = gcd(a,b);

        if(num == 1){
            ans[0] = a; ans[1] = b;
        }else{
            ans[0] = (a/num);
            ans[1] = (b/num);
        }

        return ans;

    }

}
