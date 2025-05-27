import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B1174_줄어드는수 {
    static List<Long> nums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        for (int i=1;i<=10;i++) {
            Comb(new boolean[10], 0, i, new ArrayList<>());
        }

        Collections.sort(nums);

        if (n <= nums.size()) {
            System.out.println(nums.get(n - 1));
        } else {
            System.out.println(-1);
        }
    }

    //재귀
    static void Comb(boolean[] used, int start, int r, List<Integer> now) {
        if (now.size() == r) {
            List<Integer> temp = new ArrayList<>(now);
            temp.sort(Collections.reverseOrder());
            long num = 0;
            for (int digit : temp) {
                num = num * 10 + digit;
            }
            nums.add(num);
            return;
        }

        for (int i=start;i<10;i++) {
            if (!used[i]) {
                used[i] = true;
                now.add(i);
                Comb(used, i + 1, r, now);
                now.remove(now.size() - 1);
                used[i] = false;
            }
        }
    }
}