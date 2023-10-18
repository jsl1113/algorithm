package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*
 * 부분집합 식으로 dfs하는 건 기억났지만 
 * 인덱스로 기호를 나타내는 거랑 왼쪽 부분을 전부 계산해서 sum으로 나타내는 걸 생각못했다..ㅜ
 */
public class RV_B16637_괄호추가하기 {

	static int n;
	static ArrayList<Integer> num = new ArrayList<>();
	static ArrayList<Character> gi = new ArrayList<>();
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n= Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		
		for(int i=0;i<n;i+=2) {
			int m = str.charAt(i)-'0';
			num.add(m);
		}
		for(int i=1;i<n;i+=2) {
			gi.add(str.charAt(i));
		}
		
		dfs(0,num.get(0));
		System.out.println(max);
		
	}
	/*
	 * 부분집합 마냥
	 * gi 의 사이즈는 4 
	 * 연산자의 우선순위는 동일해서 괄호를 씌울 때 (3+8)*7-9*2 의 경우는 없어도 된다..
	 */
	public static void dfs(int idx, int sum) {
		
		if(gi.size()<=idx) { //dfs(idx+2) 때문에 사이즈 이상으로 조건두기 
			max = Math.max(max, sum);
			return;
		}
		//괄호 없이 -> 앞까지의 계산결과랑 지금 기호랑 연산하기 때문에 
		//         여기에 sum이 들어간다. 
		int res = cal(sum, num.get(idx+1), idx);		
		dfs(idx+1,res);		
		
		//괄호 있이 (idx가 기호의 사이즈-1보다 커야함)
		if(idx<gi.size()-1) {
			int right = cal(num.get(idx+1), num.get(idx+2), idx+1);
			int result = cal(sum, right, idx);
			dfs(idx+2,result);
		}
	}
	public static int cal(int a, int b, int idx) {
		switch (gi.get(idx)) {
		case '+':
			return a+b;
		case '-':
			return a-b;
		case '*':
			return a*b;
			
		}
		return 0;
		
	}

}
