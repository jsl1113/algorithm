package BOJ.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B10816_숫자카드2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int card[] = new int[n]; 
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			card[i] = Integer.parseInt(st.nextToken());
			map.put(card[i], map.getOrDefault(card[i], 0)+1);
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(!map.containsKey(num)) {
				sb.append("0"+" ");
			}else {
				sb.append(map.get(num)+" ");
			}
			
		}
		
		System.out.println(sb);
		
		
		

	}

}
