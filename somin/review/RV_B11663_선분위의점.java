package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RV_B11663_선분위의점 {

	static int n,m;
	static int [] list ;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(list);
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(binary(a, b));
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	public static int binary(int a,int b) {
		int s = 0;
		int e = list.length-1;
		
		while(s<=e) {
			int mid=(s+e)/2;
			if(list[mid]<a) {
				s = mid+1;
			}else {
				e = mid-1;
			}				 
		}
		int aCnt = s;
		
		s=0;
		e = list.length-1;
		
		while(s<=e) {
			int mid=(s+e)/2;
			if(list[mid]>b) {
				e = mid-1;
				
			}else {
				s = mid+1;
				
			}	
		}
		int bCnt = e+1;
		
		return bCnt-aCnt;
	}

}
