import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1629_���� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());
		
//		long ans = (long) Math.pow(a, b);
//		ans %=c;
		
		System.out.println(pow(a, b, c));
		
//		pow(a, b, c);
	}
	/*
	 * ������Ģ + ��ⷯ ����
	 * a^(n+m) = a^n * a^m
	 * 
	 * (a*b)mod C = (a mod C * b mod C) mod C
	 */
	static long pow(long a,long b, long c) {
		
		//������ 1�̸� a�� 1���� = a ��ü�̱� ����
		if(b==1) {
			return a%c;
		}
		
		long tmp = pow(a,b/2,c);
		
		/*
		 * ���� ������ Ȧ�����
		 * a^(b/2) * a^(b/2) * a 
		 *                    �ϳ� 
		 */
		if(b%2==1) {
			return (tmp * tmp%c) * a%c;
		}
		
		return tmp * tmp %c;
	}

}
