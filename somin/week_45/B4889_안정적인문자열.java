import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B4889_안정적인문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s= "";
		
		int cnt=0;
		while((s=br.readLine()).charAt(0)!='-') {
			cnt++;
			int ans = 0;
			Stack<Character> st = new Stack<>();
			
			for(int i=0;i<s.length();i++) {
				char now = s.charAt(i);
				if(now=='{') {
					st.add('{');
				}else {
					//처음문자면;
					if(st.isEmpty()) {
						ans++;
						st.add('{');
					}else {
						st.pop();
					}
				}
			}
			System.out.println(cnt+". "+ (ans + st.size()/2));
		}
	}
	

}
