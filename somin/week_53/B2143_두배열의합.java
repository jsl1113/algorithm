import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B2143_두배열의합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		int[] arr2 = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<n;i++) {
			int sum =0;
			for(int j=i;j<n;j++) {
				sum+= arr[j];
				map.put(sum, map.getOrDefault(sum, 0)+1);
			}
		}
		
		long ans = 0;
		for(int i=0;i<m;i++) {
			int sum = 0;
			for(int j=i;j<m;j++) {
				sum+=arr2[j];
				int k = t-sum;
				if(map.containsKey(k)) {
					ans+=map.get(k);
				}
			}
		}
		System.out.println(ans);
		
	}

}
