package BOJ.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 자료구조 / 스택 문제
 * 
 * 스택에 넣을때
 * 들어와있는 알파벳과 들어올 알파벳이 같으면 삭제하면 될거같기도?
 * 그리고 홀수면 좋은 단어가 아닌것 같다.
 * 
 */
public class B3986_좋은단어 {

	static int n;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		
		int cnt=0;
		for(int i=0;i<n;i++) {
			String s = bf.readLine();
			cnt += isgood(s);
		}
		System.out.println(cnt);
		
	}
	public static int isgood(String s) {
		Stack<Character> stack = new Stack<>();
		char c[] = new char[s.length()];
		
		for(int i=0;i<s.length();i++) {
			c[i] = s.charAt(i);
		}

		stack.push(c[0]);
		
		for(int i=1;i<s.length();i++) {
			if(stack.isEmpty()) {
				stack.push(c[i]);
				continue;
			}
			else {
				char now = stack.peek();				
				if(now == c[i]) {
					stack.pop();
				}
				else {
					stack.push(c[i]);
				}
			}
			
		}
		
		
		
		if(stack.isEmpty()) {
			return 1;
		}else
			return 0;
	}

}
