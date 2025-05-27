import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16926_배열돌리기1 {

	static int n, m, r;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;//= new StringTokenizer(br.readLine());

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j =0;j<m;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rotateArray();

        StringBuilder sb = new StringBuilder();
        for (int[] aa : arr) {
            for (int aaa : aa) {
                sb.append(aaa).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void rotateArray() {
        int layers = Math.min(n, m) / 2;
        for (int i=0;i<layers;i++) {
            int rotateCount = r % getPerimeter(i);
            for (int j=0;j<rotateCount;j++) {
                rotateLayerOnce(i);
            }
        }
    }

    static int getPerimeter(int i) {
        int h = n-2*i;
        int w = m-2*i;
        return 2*(h+w-2);
    }

    static void rotateLayerOnce(int i) {
        int t = i;
        int b = n-1-i;
        int l = i;
        int r = m-1-i;

        int temp = arr[t][l];

        // 위쪽 : 왼쪽으로 이동
        for (int j=l;j<r;j++) {
            arr[t][j] = arr[t][j+1];
        }
        // 오른쪽 : 위로 이동
        for (int j=t;j<b;j++) {
            arr[j][r] = arr[j+1][r];
        }
        // 아래쪽 : 오른쪽으로 이동
        for (int j=r;j>l;j--) {
            arr[b][j] = arr[b][j-1];
        }
        // 왼쪽 : 아래로 이동
        for (int j=b;j>t;j--) {
            arr[j][l] = arr[j-1][l];
        }

        arr[t+1][l] = temp;
    }
}