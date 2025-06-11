import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1080_행렬 {

    static int n,m;
    static int[][] a,b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n][m];
        b = new int[n][m];

        for(int i=0;i<n;i++){
            String s = br.readLine();
            for(int j=0;j<m;j++){
                a[i][j] = s.charAt(j)-'0';
            }
        }

        for(int i=0;i<n;i++){
            String s = br.readLine();
            for(int j=0;j<m;j++){
                b[i][j] = s.charAt(j)-'0';
            }
        }
        if(n <3 || m<3){
            if(isSame(a,b)){
                System.out.println(0);
            }else{
                System.out.println(-1);
            }
            return;
        }

        int cnt =0;
        for(int i=0;i<=n-3;i++){
            for(int j=0;j<=m-3;j++){
                if(a[i][j]!=b[i][j]){
                    flip(i,j);
                    cnt++;
                }
            }
        }

        if(isSame(a,b)){
            System.out.println(cnt);

        }else {
            System.out.println(-1);
        }
    }

    static void flip(int r, int c){
        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                a[i][j] = 1 - a[i][j];
            }
        }
    }

    static boolean isSame(int[][] arr1,int[][] arr2){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr1[i][j] != arr2[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
