import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 1차로 그냥 이분탐색말고 하다가 범위를 보고 이건 시간초과다 생각해
 * 알고리즘 분류를 확인 -> 그래도 푸는 방법이 너무 이해 안감
 * for문 돌면서 cnt + 해주는 방법을 알고
 * lower bound , upper bound 중 전자를 해야한다는 것을 알았다
 * 이 문제는 이해는 다 했지만 이분탐색을 아직도 모르는 느낌이 들었다.
 */
public class B1300_K번째수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int k = Integer.parseInt(br.readLine());

		/*
		 * 1 2 3 4 5...
		 * 2 4 6 8 10 ...
		 * 3 6 9 ....
		 */

		//이분 탐색이라는 것을 알고....
		// 인덱스 기준으로 해야할 것 같음
		long s = 1;
		long e = k;
		
		while(s<e) {
			
			long mid = (s+e)/2;
			
			long cnt = 0;
			
			//cnt 즉, mid보다 작거나 같은 수를 세기
			for(int i=1;i<=n;i++) {
				cnt+= Math.min(mid / i, n);
			}
			
			//비교 
			if(k <= cnt) {
				e = mid;
			}else {
				s = mid+1;
			}
			
		}
		
		System.out.println(s);
		
	}

}
