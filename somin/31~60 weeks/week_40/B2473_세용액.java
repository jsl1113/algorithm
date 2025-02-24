import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2473_¼¼¿ë¾× {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		long [] arr = new long[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		
		long ans1=0,ans2=0,ans3=0;
		
		int s = 1;
		int e = n-1;
		
		long min = Long.MAX_VALUE;
		
		for(int i=0;i<n-2;i++) {
			s = i+1;
			e = n-1;
			
			while(s<e) {
				long tmp = ( arr[s] + arr[e] + arr[i]);
				
				if(Math.abs(tmp) < min) {
					min = Math.abs(tmp);
					
					ans1 = arr[i];
					ans2 = arr[s];
					ans3 = arr[e];
				}
				
				if(tmp<0) {
					s++;
				}else {
					e--;
				}
			}
		}
		
		System.out.println(ans1+" "+ans2+" "+ans3);
		
			
	}

}
