import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 1���� �׳� �̺�Ž������ �ϴٰ� ������ ���� �̰� �ð��ʰ��� ������
 * �˰��� �з��� Ȯ�� -> �׷��� Ǫ�� ����� �ʹ� ���� �Ȱ�
 * for�� ���鼭 cnt + ���ִ� ����� �˰�
 * lower bound , upper bound �� ���ڸ� �ؾ��Ѵٴ� ���� �˾Ҵ�
 * �� ������ ���ش� �� ������ �̺�Ž���� ������ �𸣴� ������ �����.
 */
public class B1300_K��°�� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int k = Integer.parseInt(br.readLine());

		/*
		 * 1 2 3 4 5...
		 * 2 4 6 8 10 ...
		 * 3 6 9 ....
		 */

		//�̺� Ž���̶�� ���� �˰�....
		// �ε��� �������� �ؾ��� �� ����
		long s = 1;
		long e = k;
		
		while(s<e) {
			
			long mid = (s+e)/2;
			
			long cnt = 0;
			
			//cnt ��, mid���� �۰ų� ���� ���� ����
			for(int i=1;i<=n;i++) {
				cnt+= Math.min(mid / i, n);
			}
			
			//�� 
			if(k <= cnt) {
				e = mid;
			}else {
				s = mid+1;
			}
			
		}
		
		System.out.println(s);
		
	}

}
