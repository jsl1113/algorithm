import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B22945_ÆÀºôµù {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//two pointer
		int s = 0;
		int e = n-1;
		int ans = 0;
		
		while(s+1<e) {
			ans = Math.max(ans, (e-s-1) * Math.min(arr[s], arr[e])) ;
			
			if(arr[s] < arr[e]) {
				s++;
			}else if( arr[s]> arr[e]) {
				e--;
			}else if(arr[s]== arr[e]) {
				s++; e--;
			}
		}
		
		System.out.println(ans);
		
	}

}
