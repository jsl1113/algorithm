import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class B13414_수강신청 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int k = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new LinkedHashMap<>();
		
		for(int i=0;i<l;i++) {
			String num = (br.readLine());
			
			//8자리 아니면 패스
			if(num.length()!=8 ) {
				continue;
			}
			
			if(map.containsKey(num)) {
				map.remove(num);
				map.put(num, 2);
			}else {
				map.put(num, 1);
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for(String key : map.keySet()) {
			Integer val = map.get(key);
			
			sb.append(key);
			cnt++;
			if(cnt==k) {
				break;
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
