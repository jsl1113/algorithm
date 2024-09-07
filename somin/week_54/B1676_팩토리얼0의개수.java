import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 10�� �������� �ִ����� �˾Ƴ��� �ȴ�.
 * 2 * 5�� ����� �˸� �ȴ�.
 * 2���������� 5�� ������ �� ���� �� �ۿ� ����.
 * 5�� ������ � �ִ��� �˾Ƴ��� ���� �� ��.
 */
public class B1676_���丮��0�ǰ��� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		if(n==0 || n==1) {
			System.out.println(0);
			return;
		}
		int ans=0;
		for(int i=n;i>=1;i--) {
			if(i%5==0) {
				int cnt = nPow(i, 5);
				ans+=cnt;
			}
		}
		System.out.println(ans);
		
	}
	
	static int nPow(int x, int n) {
		// x�� n�� ������ ��������
		// 400�� 5�� ������ �ִ��� . 5*5*5
		int cnt=0;
		while(x%n==0 && x>0 ) {
			x /= n;
			cnt++;
		}
		return cnt;
	}
	

}
