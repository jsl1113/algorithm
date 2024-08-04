package BOJ.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*
 * 원래 하려고 했던 방식: 숫자의 길이 / 2 한 값까지 괄호의 개수를 가질수있고
 * 괄호가 1~ 최대괄호개수 까지 모든 식의 값을 저장하기..
 * dfs로..?
 */
public class B16637_괄호추가하기 {

	static int n,nlen;
	static ArrayList<Integer> num = new ArrayList<>();
	static ArrayList<String> cal = new ArrayList<>();
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n =Integer.parseInt(br.readLine());
		
		
		
		String s = br.readLine();
		
		for(int i =0;i<n;i+=2) {
			num.add(s.charAt(i) -'0');
		}
		
		for(int i=1;i<n;i+=2) {
			String ss = Character.toString(s.charAt(i));
			cal.add(ss);
		}
		nlen = num.size();
	
		
		dfs(0,num.get(0));
		System.out.println(max);
	}
	public static int calculate(int a, int b, int idx) {
		switch (cal.get(idx)) {
		case "+":
			return a+b;
		case "-":
			return a-b;
		case "*":
			return a*b;
		}
		return 1;
	}
	
	public static void dfs(int idx, int sum) {
		if(idx >= cal.size()) {
			
			max = Math.max(max, sum);
			return;
		}
		//괄호 없을때
		int one = calculate(sum, num.get(idx+1), idx);
		
		dfs(idx+1, one);
		
		//괄호 치고 진행
		if(idx + 1<cal.size()) {
			
			int two = calculate(num.get(idx+1), num.get(idx+2), idx+1);
			int res = calculate(sum, two, idx);
			
			dfs(idx+2, res);
			
		}
		
	}
	

}
