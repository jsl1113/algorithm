import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//�ƽ��� �� : �� �����͸� ���� ������ Ǫ�� ����
public class B20922_��ġ�°ǽȾ� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		int max =0;
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		int ans = 0;
		int s=0; int e=0;
		int[] visit = new int[max+1];
		boolean flag = false;
		while(s<=e && e<n) {
			
			if(!flag) {
				visit[arr[e]]++;
			}
			
			if(visit[arr[e]]<=k) {
				ans = Math.max(ans, e-s+1);
				e++;
				flag = false;
			}else {
				visit[arr[s]] -=1;
				s++;
				flag = true;
			}
			
		}
		
		System.out.println(ans);
		
	}
}
