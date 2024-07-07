import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
/*
 * 이분탐색 문제
 *  - compareTo 는 문자열 비교를 수행하여 두 문자열의 사전적 순서를 결정함.
 *  음수이면 첫번째가 두번째 문자열보다 작다.
 *  양수이면 첫번째가 더 크다.
 *  0이면 두개가 같다.
 */
public class B14426_접두사찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<String> lst = new ArrayList<String>();
		
		for(int i=0;i<n;i++) {
			lst.add(br.readLine());
		}


		Collections.sort(lst);

		int ans = 0;
		for(int i=0;i<m;i++) {
			String ss = br.readLine();
			int left = 0; 
			int right = n-1;
			boolean flag = false;
			while(left<=right) {
				int mid = (left+right) / 2;
				
				if(ss.compareTo(lst.get(mid))>0) { //ss가 더 큼 = 사전적으로 뒤다.
					left = mid+1;
				}else if(ss.compareTo(lst.get(mid))<0) {
					right = mid-1;
				}else { //0이면 같은거
					flag = true;
					break;
				}
				
				if(lst.get(mid).startsWith(ss)) {
					flag = true;
					break;
				}
				
			}
			if(flag) {
				ans++;
			}
		}
		System.out.println(ans);
		
	}

}
