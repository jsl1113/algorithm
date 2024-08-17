import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* *���������� ���°�� ū �ܰ����� ���߱�
 *  ������ 1 = (7^0)*1 = 1�ܰ�
			������ 2 = (7^0)*2 = 2�ܰ�
			������ 7 = (7^1)*1 = 3�ܰ�
			������ 8 = (7^0)*1 + (7^1)*1 = 4�ܰ�
			������ 9 = (7^0)*2 + (7^1)*1 = 5�ܰ�
			������ 14 = (7^1)*2 = 6�ܰ�
 */
// ���� Ǯ�� : �������� ���� ������ ����� �� ����
// 			 �׳� �ִ� ������ ���ؼ� ��� ����� �������ؼ� ���� �� ������
// ���� : 7�� ������ �ִ� 0~2���� ����� �� �ִ� = 3����... ��� ������ ��� ��?
//       Ǯ�̸� ���� ���� �ؼ��ؼ� ǰ... ��ƴ�... 

public class B20548_ĥ���ҽ� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long c = Long.parseLong(br.readLine());
		long ans = 0;
		int digit=1;
		/*
		 * c =15     ans += 15%7 * 1  (1 *1)
		 *  15/7 = 2 
		 */
		while(c>0) {
			ans  += (c % 7)*digit;
			c /=7;  
			digit *= 3;   
		}
		System.out.println(ans);
	}

}
