import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
/*
 * 틀린 포인트: 재귀를 사용해서 abbab와 babba 중 최소값을 가져올 방법을 몰랐다.
 * 재귀 없이 코드를 길게 짰지만 모든 반례에 맞춰서 짜는 것보다 완벽한 논리를 생각하고
 * 코드를 구현하도록 해야겠다... 재귀 짱
 */

public class B17609_회문 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			String s = br.readLine();

			System.out.println(solve(0, s.length()-1, s, 0));
		}
		
	}
	
	static int solve(int start, int end, String s, int cnt) {
		
		if(cnt >=2) {
			return 2;
		}
		
		while(start < end) {
			
			if(s.charAt(start) == s.charAt(end)) { //같을 때는 패스
				start++;
				end--;
			}else { //다르면 abbab , babba 둘 다 처리하기 위해 재귀 최솟값 리턴 
				int sp = solve(start+1, end, s, cnt+1);
				int em = solve(start, end-1, s, cnt+1);
				
				return Math.min(sp, em);
			}
		}
		
		return cnt; 
		
		
	}
	

}
