import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2056_작업 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] time = new int[n + 1];
        int[] degree = new int[n + 1];
        List<Integer>[] list = new ArrayList[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            time[i] = Integer.parseInt(st.nextToken());
            int pre = Integer.parseInt(st.nextToken());

            for (int j = 0; j < pre; j++) {
                int before = Integer.parseInt(st.nextToken());
                list[before].add(i);
                degree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                dp[i] = time[i];
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : list[now]) {
                dp[next] = Math.max(dp[next], dp[now] + time[next]);
                degree[next]--;

                if (degree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);

    }

}
