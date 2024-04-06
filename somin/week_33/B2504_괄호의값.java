import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class B2504_°ýÈ£ÀÇ°ª {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String  N = br.readLine();
        Stack<Character> st = new Stack<>();
        int ans = 0;
        int value = 1;

        for(int i = 0; i < N.length(); i++) {
            if(N.charAt(i) == '(') { 
                st.push(N.charAt(i)); 
                value *= 2;
            } else if(N.charAt(i) == '[') {
                st.push(N.charAt(i)); 
                value *= 3; 
            } else if(N.charAt(i) == ')') {
                if(st.isEmpty() || st.peek() != '(') { 
                    ans = 0;
                    break;
                } else if(N.charAt(i-1) == '(') {
                    ans += value;
                }
                st.pop();
                value /= 2;
            } else if(N.charAt(i) == ']') {
                if (st.isEmpty() || st.peek() != '[') {
                    ans = 0;
                    break;
                } else if (N.charAt(i - 1) == '[') {
                    ans += value;
                }
                st.pop();
                value /= 3;
            }
        }
		
		if(!st.isEmpty()) {
			System.out.println(0);
		}else {
			System.out.println(ans);
		}
		
		
		
	}


}
