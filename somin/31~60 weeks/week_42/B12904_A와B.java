import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B12904_A와B {

	static String s,t;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		s = br.readLine();
		t = br.readLine();
		
		// 문자열의 뒤에 A추가
		// 문자열을 뒤집고 뒤에 B를 추가
		
		// B -> ABBA
		solve(t);
		if (flag) {
			System.out.println("1");
		}else
			System.out.println("0");
	}

	static void solve(String word) {
		if(flag) {
			return;
		}
		if(word.equals(s) || word.length()==s.length()) {
			if(word.equals(s)) {
				flag=true;
				return;
			}
			return;
		}
		
		
		// 반대로 : 맨뒤에 A를 빼기
		//        맨뒤에 B를 빼고 뒤집기
		if(word.charAt(word.length()-1)=='A') {
			solve(word.substring(0,word.length()-1));
		}
		
		if(word.charAt(word.length()-1)=='B') {
			word = word.substring(0,word.length()-1);
			StringBuffer sf = new StringBuffer(word);
			String rev = sf.reverse().toString();
			
			solve(rev);
			
		}
		
		
		
		
	}
	
}
