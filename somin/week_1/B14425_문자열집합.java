package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B14425_문자열집합 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int ans = 0;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<String> s = new ArrayList<String>();
		
		for(int i=0;i<N;i++) {
			s.add(bf.readLine());
		}
		
		for(int i=0;i<M;i++) {
			if(s.contains(bf.readLine())) {
				ans++;
			}
		}
		System.out.println(ans);
	}

}
