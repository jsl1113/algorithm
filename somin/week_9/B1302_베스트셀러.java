package BOJ.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class B1302_º£½ºÆ®¼¿·¯ {

	static int n;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			if(!map.containsKey(s)) {
				map.put(s, 1);
			}
			else {
				int cnt = map.get(s);
				map.replace(s, cnt+1);
			}
			
		}
		
		ArrayList<String> list = new ArrayList<String>();

		int max = 0;
		for(Integer val : map.values()) {
			if(max<val) max = val;
		}
		
		for(Map.Entry<String, Integer> m:map.entrySet()) {
			if(m.getValue() == max) list.add(m.getKey());
		}
		
		Collections.sort(list);
		
		
		System.out.println(list.get(0));
	}

}
