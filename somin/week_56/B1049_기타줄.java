import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1049_기타줄 {

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
			
			//(기타줄 6개)적어도 n개를 사기 위해 필요한 돈의 수
			all[i] = p;
			one[i] = o;
		}
		Arrays.sort(all);
		Arrays.sort(one);
		
		//6의 배수
		int ans = Integer.MAX_VALUE;
		
		//개수 딱
		int r = n % 6;
		
		if(r==0) {
			//6의 배수
			ans = Math.min(ans, (n/6)*all[0]);
		}else {
			//6 + 단일
			ans = Math.min(ans, (n/6)*all[0] + r*one[0]);			
			//6만
			ans = Math.min(ans,  (n/6 +1 )*all[0] );
		}
		//단일만
		ans = Math.min(ans, n*one[0]);
		
		
		System.out.println(ans);
		
		
	}
}
