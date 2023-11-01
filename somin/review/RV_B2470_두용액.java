package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RV_B2470_µÎ¿ë¾× {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int [] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int s=0;
		int e = n-1;
		
		int dist = Integer.MAX_VALUE;
		int x=-1;
		int y=-1;
		while(s<e) {
			int sum = arr[s]+arr[e];
			
			if(dist>Math.abs(sum)) {
				dist = Math.abs(sum);
				x = s;
				y = e;
			}
			
			if(sum>0) {
				e = e-1;
			}else if(sum<0) {
				
				s = s+1;
			}else {
				break;
			}
			
		}
	
		
		System.out.println(arr[x]+" "+arr[y]);
		
	}

}
