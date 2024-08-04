import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 방법이 안 떠올라서
 * 벌통 왼쪽 고정/벌통 오른쪽 고정/ 벌1,2 고정
 * 세가지로 나눠서 하라는 것만 보고 구현해봤다..
 * 
 * n이 4이상일때 되는 코드를 짜서 다시 짜야했다..
 * 생각보다 너무 복잡했다 ㅠ 
 */
public class B21758_꿀따기 {

	static int n;
	static long[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new long[n];
		long sum=0;
		long result = 0; //최대값
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum+=arr[i];
		}
		
		//n ==3 
		if(n==3) {
			
			for(int i=0;i<n;i++) {
				long a = arr[i]*2;
				result = Math.max(result, a);
			}
			System.out.println(result);
			
			return;
		}
		
		
		//왼쪽벌통 + 오른쪽 벌1 + 벌2 정하기
		long sumBee = sum - arr[n-1];
		long ans = sumBee;
		
		for(int i=n-2;i>=0;i--) {
			long t = sumBee - arr[i];
			ans -= arr[i];
			t+=ans;
			result = Math.max(t, result);			
		}
		
		//오른쪽벌통 + 왼쪽 벌1 + 벌2 정하기
		sumBee = sum - arr[0];
		ans = sumBee;

		for(int i=1;i<n-1;i++) {
			long t = sumBee - arr[i];
			ans-=arr[i];
			t +=ans;
			result = Math.max(t, result);
		}

		//왼쪽 벌1 + 오른쪽 벌2 +벌통 정하기
		sumBee = sum- arr[n-1];
		ans = 0;
		
		for(int i=1;i<n-1;i++) {
			ans +=arr[i];
			sumBee -=arr[i-1];
			result = Math.max(ans+sumBee, result);
		}
		
		
		System.out.println(result);
		
		
		
	}

}
