import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11060_점프점프 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr =new int[n+1];
		int[] dp =new int[n+1];
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(n==1) { //1인 경우는 따로 출력
			System.out.println(0);
			return;
		}
		
		for(int i=1;i<=n;i++) {
			if(arr[i]==0) { 
				continue;
			}
			if(i!=1 && dp[i]==0) { //dp가 0이라는 것은 여기까지 도달 못했다는 뜻
				continue;
			}
			for(int j=1;j<=arr[i];j++) {
				if(j+i<=n) { //index 초과 방지
					if(dp[i+j]!=0) { 
						dp[i+j] = Math.min( dp[i] + 1, dp[i+j]);
					}else { //한번도 방문 안한 미로면 +1 해주면 됨
						dp[i+j] = dp[i] + 1;
					}
				}
			}
			
			
		}
		
		System.out.println(dp[n]==0?-1:dp[n]);
	}

}
