package BOJ.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11399_ATM {

	static int[] list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		
		list = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(list);
	
		int sum=0;
		for(int i=0;i<n;i++) {
			int cnt =0;
			for(int a : list) {
				cnt++;
				sum+= a;
				if(cnt==i+1) break;
			}
		
		}
		
		System.out.println(sum);
	}

}
