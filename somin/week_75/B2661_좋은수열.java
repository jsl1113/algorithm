import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2661_좋은수열 {
	static int n;
	static boolean flag=false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		bt("");
	}
	
	static void bt(String s) {
		if(flag) {
			return;
		}
		
		if(s.length()==n) {
			System.out.println(s);
			flag = true;
			return;
		}
		
		for(int i=1;i<=3;i++) {
			String now = s + i;
			if(check(now)) {
				bt(now);
			}
		}
		
		
	}
	
	//좋은 수열 체크
	static boolean check(String s) {
		//
		int len = s.length();
		for(int i=1;i<=len/2;i++) {
			String l = s.substring(len-2*i, len-i);
			String r = s.substring(len-i);
			if(l.equals(r)) {
				return false;
			}
		}
		
		return true;
	}

}
