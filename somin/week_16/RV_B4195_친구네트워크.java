package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class RV_B4195_模备匙飘况农 {

	static int[] node,d;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int k=0;k<t;k++) {
			int f = Integer.parseInt(br.readLine());
			
			node = new int[f*2];
			d = new int[f*2];
			
			for(int i=0;i<f*2;i++) {
				node[i]= i;
				d[i] = 1;
			}
			
			Map<String, Integer> map = new HashMap<String, Integer>();
			int cnt=0;
			for(int i=0;i<f;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				
				if(!map.containsKey(a)) {
					map.put(a, cnt);
					cnt++;
				}
				if(!map.containsKey(b)) {
					map.put(b, cnt);
					cnt++;
				}
				
				                     //    Fr= 0       Bar= 1
				System.out.println(union(map.get(a), map.get(b)));
				
			}
		}
		
	}
	static int union(int a, int b) {
		int A = find(a);
		int B = find(b);
		if(A!=B) {
			if(A<B) { //a啊 何葛
				node[B] = A;
				d[A]+=d[B];
				return d[A];
			}else {
				node[A] = B;
				d[B] += d[A];
				return d[B];
			}
		}
		return d[A];
	}

	static int find(int a) {
		if(node[a]==a) return a;
		
		return node[a] = find(node[a]);
	}
}
