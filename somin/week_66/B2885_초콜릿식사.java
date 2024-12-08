import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2885_���ݸ��Ļ� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		
		/*
		 * k���� ���簢���� ��������.
		 * �ּ� ������� ũ�� ?
		 * �ּ� ��� �߶�� �ϳ�
		 * 
		 * ex) k = 6 
		 * 
		 * 1,2,4,8,16,32
		 * 2�� �����̴�. 
		 * �׷� ������ �̵� ���̿� ������
		 * 
		 */
		
		
		boolean flag = false;
		int min_choco = 0;
		//���� ���� ���� ���� ���� ���ڸ���  
		for(int i=0;i<Math.sqrt(1000000);i++) {
			if(Math.pow(2, i)>=k) {
				min_choco = (int) Math.pow(2, i);
				if(Math.pow(2, i)==k) {
					flag = true;
				}
				break;
			}
		}
		
		
		if(flag) {  //���� ���� ������ �ٷ� return
			System.out.println(min_choco+" "+0);
			return;
		}
		
		//min choco���ٴ� k�� �۴�. �׷� ��� �ڸ��� ����
		int cnt=0;
		int len = min_choco;
		while(k>0) {  //k�� 0�̵Ǹ� ����
			if(k<len) {
				len /=2;
				cnt++;
			}else { //���� k�� �� ũ�ų� ����.
				k -= len;  //���ϴ� ũ��� �پ���.
			}
			
		}
		
		System.out.println(min_choco+" "+cnt);
		
		
	}

}
