package BOJ.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B10799_�踷��� {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String s = bf.readLine();
		
		Stack<Character> stack = new Stack<>();
		
		int ans=0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='(') {
				stack.push(s.charAt(i));
			}
			else {
				stack.pop();
				//��������
				if(s.charAt(i-1)=='(') {
					ans +=stack.size();
				}
				else //  )) �� +1
					ans++;
			}

		}
		
		System.out.println(ans);
	}

}
