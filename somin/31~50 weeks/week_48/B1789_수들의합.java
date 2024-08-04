import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * �ּ��� �ڿ����� ���� ����ٰ� s���� Ŀ���� 
 * ���� n���� �ڿ������� 1�� �� ������ s�� ���� �� �ִٴ� ���̴�.
 * 
 * 11) 1+2+3+4+5 = 15 �׷� �ڿ��� 5���δ� ������� 4���� ���� �� ����
 *                 (15-11)�� 4�� ���� �ȴ�. 
 *  �� �������� ����� 15) (15+6)�� �Ǵµ� 
 *                 �̶� num-1�� �����̱⶧���� ������.
 */
public class B1789_�������� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long s = Long.parseLong(br.readLine());
		
		
		int num = 1;
		long sum = 0; //long ����
		
		while(true) {
			sum += num;
			
			if(sum > s) {
				break;
			} 
			
			num++;
		}
		System.out.println(num-1);

	}

}
