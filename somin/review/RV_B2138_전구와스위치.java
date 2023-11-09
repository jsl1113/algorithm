package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RV_B2138_전구와스위치 {

	static int n;
	static boolean [] answer ;
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		String s =br.readLine();
		String ss =br.readLine();
		
		boolean [] initial =new boolean[n];
		boolean [] initial2 =new boolean[n];
		answer =new boolean[n];
	
	
		for(int i=0;i<n;i++) {
			if(s.charAt(i)=='1') initial[i]= true;
			if(s.charAt(i)=='1') initial2[i]= true;
			if(ss.charAt(i)=='1') answer[i]= true;
			
		}
		
		//0번째를 바꾼거부터 시작 / 1번째부터 시작
		greedy(1, 0, initial);
//		System.out.println(result+" ////1");
		greedy(1, 1, change(0, initial2));
//		System.out.println(result+" ////2");
		
		if(result==Integer.MAX_VALUE)System.out.println(-1);
		else
			System.out.println(result);
	}
	public static void greedy(int i, int cnt, boolean[] list) {
		if(i == n) {
			if(list[i-1]== answer[i-1]) {
		
				result = Math.min(cnt, result);
			}
			return;
		}
		
		if(list[i-1] != answer[i-1]) {
			greedy(i+1, cnt+1, change(i, list));
		}else {
			greedy(i+1, cnt, list);
		}
	}
	
	public static boolean[] change(int i, boolean [] list) {
		if(i==0) {
			list[i] = !list[i];
			list[i+1] = !list[i+1];
		}else if(i==n-1) {
			list[i] = !list[i];
			list[i-1] = !list[i-1];
		}else if(i>0 && i<n-1) {
			list[i-1] = !list[i-1];
			list[i] = !list[i];
			list[i+1] = !list[i+1];
		}
		return list;
	}
	
	
	

}
