import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B2170_선긋기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;//= new StringTokenizer(br.readLine());

        int n = Integer.parseInt(br.readLine());

        long[][] arr = new long[n][2];


        for(int i=0;i<n;i++){
            st= new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            arr[i][0] = x;
            arr[i][1] = y;

        }

        Arrays.sort(arr, Comparator.comparingLong((long[] o)-> o[0]));

        long s = arr[0][0];
        long e = arr[0][1];
        long ans = 0;

        for(int i=1;i<n;i++){
            if(e<arr[i][0]){
                ans += (e-s);
                s = arr[i][0];
                e = arr[i][1];
            }else{
                e = Math.max(e, arr[i][1]);
            }
        }

        ans += e-s;
        System.out.println(ans);


    }
}
