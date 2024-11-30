import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
/*
 * Ʋ�� ����Ʈ: ��͸� ����ؼ� abbab�� babba �� �ּҰ��� ������ ����� ������.
 * ��� ���� �ڵ带 ��� ®���� ��� �ݷʿ� ���缭 ¥�� �ͺ��� �Ϻ��� ���� �����ϰ�
 * �ڵ带 �����ϵ��� �ؾ߰ڴ�... ��� ¯
 */

public class B17609_ȸ�� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			String s = br.readLine();

			System.out.println(solve(0, s.length()-1, s, 0));
		}
		
	}
	
	static int solve(int start, int end, String s, int cnt) {
		
		if(cnt >=2) {
			return 2;
		}
		
		while(start < end) {
			
			if(s.charAt(start) == s.charAt(end)) { //���� ���� �н�
				start++;
				end--;
			}else { //�ٸ��� abbab , babba �� �� ó���ϱ� ���� ��� �ּڰ� ���� 
				int sp = solve(start+1, end, s, cnt+1);
				int em = solve(start, end-1, s, cnt+1);
				
				return Math.min(sp, em);
			}
		}
		
		return cnt; 
		
		
	}
	

}
