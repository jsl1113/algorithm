import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class B18870_ÁÂÇ¥¾ÐÃà {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		HashSet<Integer> set = new HashSet<>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> lst = new ArrayList<Integer>(set);
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			set.add(arr[i]);
		}
		
		Collections.sort(lst);
		int idx=0;
		for(int l :lst) {
			map.put(l, idx++);
		}

		for(int i=0;i<n;i++) {
			sb.append(map.get(arr[i])+" ");
		}
		System.out.println(sb);
	}

}
