package BOJ.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * 자료 구조/ 정렬 /이분 탐색 / 해시를 사용한 집합과 맵
 */
public class B10815_숫자카드 {

	static int n,m;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			map.put(Integer.parseInt(st.nextToken()), 1);
		}
	
		m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {
			if(map.containsKey(Integer.parseInt(st.nextToken()))) {
				sb.append(1+" ");
			}else
				sb.append(0+" ");
		}
		
		System.out.println(sb);

	}

}
