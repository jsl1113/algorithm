package BOJ.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
/*
 * 사실 문제 이해가 안돼서 풀수가 없었다.
 * 지금도 이해를 하고 있는지 확신이 없다.
 * https://codingrapper.tistory.com/193
 * 이걸보고 살짝 이해했는데 저 삼각수열의 정의를 모르겠따... 
 */
public class B1548_부분삼각수열 {

	static int n;
	static int[] a;
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(bf.readLine());
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		a = new int[n];
		
		for(int i=0;i<n;i++) {
			a[i] = Integer.parseInt(st.nextToken());
			
		}
		Arrays.sort(a);
	
		int min = 1;
		if(n>2) {
			for(int i=0;i<n-1;i++) {
				for(int j=n-1;j>=0;j--) {
					if(i+1 ==j) break;
					
					if(a[i]+a[i+1]>a[j]) {
						min = Math.max(min, j-i+1);
						break;
					}
					
				}
			}
		}
		if(min ==1 && n>=2) min =2;
		
		System.out.println(min);
		
		//길이가 2 이하이면 항상 삼각수열이다.
		
	}

}
