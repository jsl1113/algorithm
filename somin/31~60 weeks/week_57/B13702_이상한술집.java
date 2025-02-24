import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//후기 : 내가 이분탐색을 이렇게 쉽게 풀다니.. 감격스럽다. 이제 좀 이해가 된 듯
public class B13702_이상한술집 {

	static int n,k;
	static int pot[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		pot = new int[n];
		
		for(int i=0;i<n;i++) {
			pot[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(pot);
		
		if(n==k) {
			System.out.println(pot[n-1]);
			return;
		}
		
		
		int s = 0;
		int e = pot[n-1];
		
		while(s<e) {
			int mid = (s+e)/2;
			
			int cnt = 0;
			for(int i=0;i<n;i++) {
				cnt += pot[i]/mid;
			}
			
			if(cnt >= k) { 
				s = mid+1;
			}else if(cnt<k) { //용량이 더 작아야함
				e = mid;
			}
			
		}
		System.out.println(s-1);
	}

}
