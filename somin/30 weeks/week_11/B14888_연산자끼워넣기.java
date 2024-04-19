package BOJ.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B14888_연산자끼워넣기 {

	static int n;
	static int[] a;
	static Character[] cal;
	static boolean[] visit;
	
	static int[] gi = new int[4]; //+ - x /
	static int min=Integer.MAX_VALUE;
	static int max=Integer.MIN_VALUE;
	static ArrayList<Character> m = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		a = new int[n];
		cal = new Character[n-1];
		visit = new boolean[n-1];
		String str = br.readLine();
		
		String [] lst = str.split(" ");
		for(int i=0;i<n;i++) {
			a[i] = Integer.parseInt(lst[i]);
		}

		String str2 = br.readLine();
		String [] lst2 = str2.split(" ");
		
		for(int i=0;i<4;i++) {
			gi[i] = Integer.parseInt(lst2[i]);
		
			if(gi[i]!=0) giho(i, gi[i]);
		}
		for(int i=0;i<n-1;i++) {
			cal[i] = m.get(i);
		}


		dfs(0,a[0]);
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void dfs(int idx, int sum) {
		if(idx ==n-1) {
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0;i<n-1;i++) {
			if(!visit[i]) {
				visit[i] = true;

				dfs(idx+1, calculate(sum, i, idx));
				visit[i] = false;
				
			}
		}
		
	}
	/*
	 * 3 5 7
	 * 3이랑 5를 계산할 차례면 idx = 0 / sum = 3  
	 * cal[i] = dfs에서 고른 기호
	 * 그 기호대로 계산하고 sum이랑 그다음 숫자인 a[idx+1] 계산
	 */
	public static int calculate(int sum , int i, int idx) {
		switch (cal[i]) {
		case '+':
			return sum + a[idx+1];	
		case '-':
			return sum - a[idx+1];
		case '*':
			return sum * a[idx+1];
		case '/':
			return sum / a[idx+1];
		}
		return -1;
	}
	
	//m이라는 어레이리스트에 기호를 순서대로 넣음 (ex) +,+,-,-,-,*
	public static Character giho(int idx, int gigi) {
		switch (idx) {
		case 0:
			
			for(int i=0;i<gigi;i++) {
				
				m.add('+');					
			}
			break;
		case 1:
			
			for(int i=0;i<gigi;i++) {
			
				m.add('-');					
			}
			break;
		case 2:
		
			for(int i=0;i<gigi;i++) {
			
				m.add('*');					
			}
			break;
		case 3:
			
			for(int i=0;i<gigi;i++) {
			
				m.add('/');					
			}
			break;
		}
		
		return '0';
	}

}
