import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B3273_두수의합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int [n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int x = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		
		int s = 0;
		int e = n-1;
		
		int ans=0;
		
		while(s<e) {
			int num = arr[s]+arr[e];
			
			if(num<x) {
				s++;
			}else if(num>=x) {
				e--;
				if(num == x) {
					ans++;
				}
			}
			
		}
		System.out.println(ans);
	}

}
