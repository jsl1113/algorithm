import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17266_어두운굴다리 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[] arr = new int[m];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int s=0;
		int e=n;
		
		while(s<e) {
			int h = (s+e)/2;
			
			boolean flag = true;
			if(arr[0]>h || n-arr[m-1]>h) {
				flag = false;
			}
			if(flag) {
				for(int i=0;i<m-1;i++) {
					if(arr[i+1]-arr[i]> 2*h) {
						flag = false;
						break;
					}
				}
			}
			
			if(!flag) { // 높이가 부족하다
				s = h+1; 
			}else {
				e = h;
			}
			
		}
		System.out.println(e);
		
		
	}

}
