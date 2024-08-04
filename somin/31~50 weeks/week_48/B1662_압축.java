import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1662_���� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split("");
		
		Stack<String> stack = new Stack<>();
		// ó������ ������ char���� ���µ� ���ڸ� ǥ���ϱ� ���� string���� �ٲ�
		 
		long result=0;
		
		for(int i=0;i<s.length;i++) {
			
			if(s[i].equals(")")) {
				int ff=0;
				int in_cnt=0;
				while(!stack.isEmpty()) {
					String now = stack.pop();
					if(now.equals("(")) {
						ff = Integer.parseInt(stack.pop());
						break;
					}else if(now.equals("n")) {
						in_cnt += Integer.parseInt(stack.pop());
					}else {
						in_cnt++;
					}
				}
				
				in_cnt = in_cnt*ff;
				String sss = Integer.toString(in_cnt);
				stack.add(Integer.toString(in_cnt));
				stack.add("n");
			
			}else {
				stack.add(s[i]);
			}
			
		}
		while(!stack.isEmpty()) {
			if(stack.peek().equals("n")) {
				stack.pop();
				int tmp = Integer.parseInt(stack.pop());
				result += tmp;
			}else {
				stack.pop();
				result++;
			}
		}
		
		System.out.println(result);
	}

}
