import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
/*
 * BufferedReader StringTokenizer ��� Scanner ���ϱ� ��Ÿ�ӿ��� �ذ� ;
 * 
 * ���⼭�� ���η� �ڸ��� ���η� �ڸ��⸦ �����ؼ� ���� �������� +1 -1 �ϴ� ���
 */
public class B20444_�����̿Ͱ��� {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		
		
		long n = sc.nextInt();
		long k = sc.nextLong();
		
		long s = 0;
		long e = n/2; //���η� �ڸ� Ƚ�� == ���η� �ڸ� Ƚ��
		
		
		while(s<=e) {
			
			long mid = (s+e)/2;
			
			//���η� �ڸ� Ƚ�� + ���η� �ڸ� Ƚ�� = n
			
			long vert  = n - mid; //���� 
			
			// ���� ���� ���� 
			long pieces = (mid+1)*(vert+1);
			
			if(pieces == k) {
				System.out.println("YES");
				return;
			}else if(pieces > k) { //������ ���� �ٿ�
				e = mid -1;
			}else {   //������ ���� �ø���
				s = mid +1; 
			}
			
		}
		System.out.println("NO");
		
	}

}
