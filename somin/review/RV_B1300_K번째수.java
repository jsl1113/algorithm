package review.w14Over;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * �̺�Ž���̶�� ���� ���� Ǯ�̹���� ��������.
 * �ٵ� ������ �������ִ� �Ϳ��� ��̴�
 */
public class RV_B1300_K��°�� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		//���ڸ� ã�´�
		long s = 1;
		long e = k; //? ó���� n*n���� ���
		
		while(s<e) {
			
			long mid = (s+e)/2;
			
			long nums = 0;
			//1~n����
			for(int i=1;i<=n;i++) {
				nums += Math.min(mid/i,n); //���⼭ n���� �񱳸� ������Ѵٴ� ���� ������
				
			}
			System.out.println(nums);
			
			if(nums>=k) {
				e = mid;
			}else {
				s = mid+1;
			}
			
		}
		System.out.println(s);
		
		
		
		
	}

}
