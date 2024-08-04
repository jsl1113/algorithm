package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B14002_가장긴증가하는부분수열4 {

	static int a;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		a = Integer.parseInt(br.readLine());
		arr = new int[a];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<a;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int []cnt = new int[a];
		cnt[0] = 1; 
		
		for(int i=1;i<a;i++) {
			cnt[i] = 1;
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i]) {
					cnt[i] = Math.max(cnt[i], cnt[j]+1);
				}
				
			}
		}
		int idx = 0;
		int an = 0;
		for(int i=0;i<a;i++) {
			if(cnt[i]>idx) {
				idx = cnt[i];
				an = i;
			}
		}
		
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		System.out.println(idx);
		for(int i=a-1;i>=0;i--) {
			if(cnt[i] == idx) {
				ans.add(arr[i]);
				idx--;
			}
		}
		Collections.reverse(ans);
	
		for(int d : ans) {
			System.out.print(d+" ");
		}
		
		
	}

}
