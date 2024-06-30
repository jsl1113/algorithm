import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2304_창고다각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[1001];
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		int val_max = Integer.MIN_VALUE;
		int idx = 0;
		int ans = 0;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			arr[l] = h;
			min = Math.min(min, l);
			max = Math.max(max, l);

			if(val_max <h) {
				idx = l;
				val_max = Math.max(val_max, h);
			}
		}

		
		int pre = arr[min];
		for(int i=min;i<idx;i++) {
			if(arr[i]==0) {
				ans+= pre;
				continue;
			}
			
			if(pre < arr[i]) {
				pre = arr[i];
			}
			ans+= pre;
			
		}
		
		pre = arr[max];
		for(int i=max;i>idx;i--) {
			if(arr[i]==0) {
				ans+= pre;
				continue;
			}
			
			if(pre < arr[i]) {
				pre = arr[i];
			}
			
			ans+= pre;
			
		}
		
		System.out.println(ans+val_max);
		
	}
 
}
