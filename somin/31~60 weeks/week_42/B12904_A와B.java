import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B12904_A��B {

	static String s,t;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		s = br.readLine();
		t = br.readLine();
		
		// ���ڿ��� �ڿ� A�߰�
		// ���ڿ��� ������ �ڿ� B�� �߰�
		
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
		
		
		// �ݴ�� : �ǵڿ� A�� ����
		//        �ǵڿ� B�� ���� ������
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
