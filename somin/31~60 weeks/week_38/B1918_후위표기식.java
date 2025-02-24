import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class B1918_후위표기식 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String [] s = br.readLine().split("");
		
		Stack<String> stack = new Stack<String>();
		StringBuilder sb = new StringBuilder();

		//()
		// * / 
		// + - 
		for(int i=0;i<s.length;i++) {
			//알파벳이면 넣어주기 65 <= 90
			int now = (s[i].charAt(0));
			if( now >= 65 && now<=90) {
				sb.append(s[i]);
			}else if(s[i].equals("(")) {
				stack.push(s[i]);
			}else if(s[i].equals(")")) {
				while(!stack.isEmpty() && !stack.peek().equals("(")) {
					String p = stack.pop();
					sb.append(p);
				}
				if(!stack.isEmpty()) {
					stack.pop();
				}
			}else if(s[i].equals("*") || s[i].equals("/") ) {
				while(!stack.isEmpty() && (stack.peek().equals("*") ||stack.peek().equals("/"))) {
					String p = stack.pop();
					sb.append(p);
				}
				stack.push(s[i]);
			}else if(s[i].equals("+") || s[i].equals("-")) {
				while(!stack.isEmpty() && (stack.peek().equals("*")||stack.peek().equals("/")
						||stack.peek().equals("+")||stack.peek().equals("-"))) {
					String p = stack.pop();
					sb.append(p);
				}
				stack.push(s[i]);
			}
			
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);
		
	}

	
}
