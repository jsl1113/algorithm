import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1253_���� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int [] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0;i<n;i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int ans = 0;
		
		for(int i=0;i<n;i++) { //1���� �����Ϸ��� �ϴϱ� Ʋ�Ƚ��ϴ�. ��..
			
			int now = arr[i];
			
			boolean flag = false;
			
			int s = 0;
			int e = n-1; // 0 1 1 �� ��찡 ���� �� ���� -> ������ n������ ������
			
			if(i == n-1) {
				e--;
			}else if(i == 0) {
				s++;
			}
			
			while(s<e) {
				int sum = arr[s] + arr[e];
				
				if(sum == now) {
					flag = true;
					break;
				}else if(sum < now){ //���� �۴� . s ++
					s++;
					if(s == i) {
						s++;
					}
				}else if(sum > now) { //���� ũ�� e --
					e--;
					if(e == i) {
						e--;
					}
				}
			}
			
			if(flag) {
				ans++;
			}
			
		}
		
		System.out.println(ans);
		
	}

}
