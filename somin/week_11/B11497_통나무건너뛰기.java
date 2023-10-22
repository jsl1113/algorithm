package BOJ.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11497_통나무건너뛰기 {

	static int t, n;
	static int[] list;
	static int[] ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++) {
			n = Integer.parseInt(br.readLine());
			list = new int [n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				list[j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(list);
			
			int start = 0;
			if(n%2==0) start = n/2-1;
			else
				start = n/2;
			
			ans = new int[n];
			ans[start] = list[0];
			
			for(int k=1;k<n;k++) {
				if(k%2!=0) { // 홀수번째
					ans[start+(k/2+1)]= list[k];
				}else {
					ans[start-(k/2)]=list[k];
				}
			}

			int max = -1;
			for(int l=0;l<n-1;l++) {
				max = Math.max(max, Math.abs(ans[l]-ans[l+1]));
			}
			max = Math.max(max, Math.abs(ans[0]-ans[n-1]));
			
			System.out.println(max);
			
		}
	}

}
