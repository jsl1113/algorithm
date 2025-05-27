import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B12847_꿀아르바이트 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] wage = new long[n+1];
        st= new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            wage[i] = Integer.parseInt(st.nextToken());
        }

        long[] sum = new long[n+1];

        for(int i=1;i<=n;i++){
            sum[i] = sum[i-1] + wage[i];
        }

        long ans = 0;
        for(int i=1;i<=n-m+1;i++){
            long now = sum[i+m-1] - sum[i-1];
            ans = Math.max(ans, now);
        }
        System.out.println(ans);
    }
}
