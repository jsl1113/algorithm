import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1475_방번호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] n = (br.readLine()).split("");
		
		int[] cnt = new int[10];
		int ans = 1;
		Arrays.fill(cnt, 1);
		for(int i=0;i<n.length;i++) {
			int num = Integer.parseInt(n[i]);
			if(cnt[num]==0) {
				if(num == 6 && cnt[9]>0) {
					cnt[9]--;
				}else if(num ==9 && cnt[6]>0) {
					cnt[6]--;
				}else {
					for(int j=0;j<10;j++) {
						cnt[j]++;
					}
					ans++;
					cnt[num]--;
				}
					
			}else { //세트가 0개보다 많이 남아있을 때
				cnt[num]--;
			}
			
		}

		System.out.println(ans);
	}
	
	

}
