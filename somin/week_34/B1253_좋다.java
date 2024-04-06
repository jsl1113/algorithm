import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1253_좋다 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int [] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0;i<n;i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int ans = 0;
		
		for(int i=0;i<n;i++) { //1부터 시작하려고 하니까 틀렸습니다. 뜸..
			
			int now = arr[i];
			
			boolean flag = false;
			
			int s = 0;
			int e = n-1; // 0 1 1 의 경우가 있을 수 있음 -> 범위가 n끝까지 봐야함
			
			if(i == n-1) {
				e--;
			}else if(i == 0) {
				s++;
			}
			
			while(s<e) {
				int sum = arr[s] + arr[e];
				
				if(sum == now) {
					flag = true;
					break;
				}else if(sum < now){ //합이 작다 . s ++
					s++;
					if(s == i) {
						s++;
					}
				}else if(sum > now) { //합이 크다 e --
					e--;
					if(e == i) {
						e--;
					}
				}
			}
			
			if(flag) {
				ans++;
			}
			
		}
		
		System.out.println(ans);
		
	}

}
