import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B4811_알약 {
    static long[][] memo;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            memo = new long[N + 1][N + 1];
            for (int i=0; i<=N; i++) {
                for (int j=0; j<=N; j++) {
                    memo[i][j] = -1;
                }
            }
            System.out.println(count(N, 0));
        }
    }

    static long count(int whole, int half) {
        if (whole == 0 && half == 0) return 1;

        if (memo[whole][half] != -1) return memo[whole][half];

        long res = 0;
        if (whole > 0) {
            res += count(whole - 1, half + 1);
        }
        if (half > 0) {
            res += count(whole, half - 1);
        }

        memo[whole][half] = res;

        return res;
    }
}