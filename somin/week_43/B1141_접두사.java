import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class B1141_접두사 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		ArrayList<String> arrlst = new ArrayList<String>();

		for(int i=0;i<n;i++) {
			arrlst.add(br.readLine());
		}
		Collections.sort(arrlst);
		
		int reverseAns = 0;
		
		for(int i=0;i<arrlst.size();i++) {
			String now = arrlst.get(i);
			for(int j=i+1;j<arrlst.size();j++) {
				String nxt = arrlst.get(j);
				if(now.charAt(0) != nxt.charAt(0)) {
					break;
				}
				if(now.length()>nxt.length()) {
					continue;
				}else {
					String cut = nxt.substring(0,now.length());
					//같은지 비교
					if(cut.equals(now)) {
						reverseAns++;
					}
					break;
				}
			}
		}
		System.out.println(n-reverseAns);
	}
}
