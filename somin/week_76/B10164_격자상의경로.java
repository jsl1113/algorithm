import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10164_격자상의경로 {
    static int n,m,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if(k==0){
            System.out.println(cnt(0,0,n-1,m-1));
        }

        //k 좌표로
        int r = (k-1)/m;
        int c = (k-1)%m;

        //k까지
        int toK = cnt(0,0,r,c);
        //k부터 n*m까지
        int toNM = cnt(r,c,n-1,m-1);

        System.out.println(toK*toNM);

    }

    static int cnt(int x1, int y1, int x2, int y2){
        int r = x2-x1+1;
        int c = y2-y1+1;

        int[][] dp = new int[r][c];
        for(int i=0;i<r;i++){
            dp[i][0] = 1;
        }
        for(int i=0;i<c;i++){
            dp[0][i] = 1;
        }

        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[r-1][c-1];
    }

}
