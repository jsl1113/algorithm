import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1049_��Ÿ�� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] all = new int[m];
		int[] one = new int[m];
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int o = Integer.parseInt(st.nextToken());
			
			//(��Ÿ�� 6��)��� n���� ��� ���� �ʿ��� ���� ��
			all[i] = p;
			one[i] = o;
		}
		Arrays.sort(all);
		Arrays.sort(one);
		
		//6�� ���
		int ans = Integer.MAX_VALUE;
		
		//���� ��
		int r = n % 6;
		
		if(r==0) {
			//6�� ���
			ans = Math.min(ans, (n/6)*all[0]);
		}else {
			//6 + ����
			ans = Math.min(ans, (n/6)*all[0] + r*one[0]);			
			//6��
			ans = Math.min(ans,  (n/6 +1 )*all[0] );
		}
		//���ϸ�
		ans = Math.min(ans, n*one[0]);
		
		
		System.out.println(ans);
		
		
	}
}
