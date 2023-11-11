package BOJ.union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/*
 * 유니온 할때 크기 큰 걸 부모로 하고 갯수를 카운트 해놓는다니..
 * 이런 생각은 어떻게 하죠
 */
public class B4195_친구네트워크 {

	static int[] parents,level;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int k =0;k<t;k++) {
			int f = Integer.parseInt(br.readLine());
			parents = new int[f*2];
			level = new int[f*2];
			for(int i=0;i<f*2;i++) {
				parents[i] = i;
				level[i] = 1;
			}
			
			Map<String, Integer> map = new HashMap<String, Integer>();
			int cnt=0;
			for(int i=0;i<f;i++) {
				st = new StringTokenizer(br.readLine());
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
				
				
				System.out.println(union(map.get(a), map.get(b)));
				
//				System.out.println(Arrays.toString(parents));
//				System.out.println(Arrays.toString(level));
			}
			
			
			
		}
		
	}
	public static int union(int a , int b) {
		int A = find(a);
		int B = find(b);
		
		if(A!=B) {
			if(B>A) {
				parents[B] = A;
				level[A] += level[B];
				return level[A];
			}else {
				parents[A] = B;
				level[B] += level[A];
				return level[B];
			}
		}
		return level[A];
	}
	public static int find(int a) {
		if(parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

}
