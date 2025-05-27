import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1911_흙길보수하기 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][2];

        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] =  Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr, (a,b)-> Integer.compare(a[0], b[0]));

        int ans = 0;      
        int box = 0;       

        for (int i=0;i<n;i++) {
            int s = arr[i][0];
            int e = arr[i][1];

            if (box < s) {
            	box = s;
            }

            while (box < e) {
            	box += l;   
                ans++; 
            }
        }

        System.out.println(ans);

    }

}
