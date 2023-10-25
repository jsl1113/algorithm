package BOJ.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B20437_문자열게임2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			String input = br.readLine();
			int k = Integer.parseInt(br.readLine());
			
			int[] alpa = new int[26];
			
			for(int i=0;i<input.length();i++) {
				alpa[input.charAt(i)-'a']++; 
			}
			
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			
			for(int i=0;i<input.length();i++) {
				if(alpa[input.charAt(i)-'a']<k) continue;
				int cnt = 1;
				for(int j=i+1;j<input.length();j++) {
					if(input.charAt(i)==input.charAt(j)) cnt++;
					if(cnt == k ) {
						min = Math.min(min, j-i+1);
						max = Math.max(max, j-i+1);
						break;
					}
				}
			}
			
			if(min == Integer.MAX_VALUE || max ==Integer.MIN_VALUE) {
				System.out.println(-1);
			}else {
				System.out.println(min+" "+max);
			}
			
		}
		
		
	}

}
