import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B3151_합이0 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        long ans = 0;

        for(int i = 0; i < n; i++) {
            if(arr[i] > 0) break;  // 정렬된 상태이므로 더 진행할 필요 없음
            
            int s = i + 1;
            int e = n - 1;
            
            while(s < e) {
                int sum = arr[i] + arr[s] + arr[e];
                
                if(sum == 0) {
                    if(arr[s] == arr[e]) {
                        int cnt = e - s + 1;
                        ans += (long)cnt * (cnt - 1) / 2;
                        break;
                    }

                    int cs = 1;
                    int ce = 1;

                    // s와 같은 값 세기
                    while(s + 1 < e && arr[s] == arr[s + 1]) {
                        cs++;
                        s++;
                    }

                    // e와 같은 값 세기
                    while(s < e - 1 && arr[e] == arr[e - 1]) {
                        ce++;
                        e--;
                    }

                    ans += (long) cs * ce;
                    s++;
                    e--;
                } else if(sum < 0) {
                    s++;
                } else {
                    e--;
                }
            }
        }

        System.out.println(ans);
    }
}