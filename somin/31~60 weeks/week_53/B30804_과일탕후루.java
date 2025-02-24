import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B30804_과일탕후루 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int s = 0; 
		int ans = 0;
		
		for(int i=0;i<n;i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
			}else {
				map.put(arr[i], 1);
			}
			while(map.size()>2) {
				map.put(arr[s], map.get(arr[s])-1);
			
				if(map.get(arr[s])==0) {
					map.remove(arr[s]);
				}
				s++;
			}
			ans = Math.max(ans, i-s +1 );
		}
		System.out.println(ans);
		
		
	}

}
