import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1874_스택수열 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		int s = 0;
		
		for(int i=0;i<n;i++) {
			int now = Integer.parseInt(br.readLine());
			
			if(now>s) {
				for(int j=s+1;j<=now;j++) {
					stack.push(j);
					sb.append("+");
					sb.append("\n");
				}
				s = now;
			}
		
			if(stack.peek() != now){
				System.out.println("NO");
				return;
			}else {
				stack.pop();
				sb.append("-");
				sb.append("\n");
			}
			
		}
		System.out.println(sb);
		
	}

}
