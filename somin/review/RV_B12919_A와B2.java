package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RV_B12919_A¿ÍB2 {

	static String s,t;
	static int ans=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		t = br.readLine();
		
		make(t);
		System.out.println(ans);
		
	}
	
	public static void make(String ls) {
		
		if(ls.length() == s.length()) {
			if(ls.equals(s)) {
				ans = 1;
				return;				
			}
			
			else
				return;
		}
		
		
		if(ls.charAt(ls.length()-1)=='A') {
			String ss = ls.substring(0, ls.length()-1);
						
			make(ss);
		}
		
		if(ls.charAt(0) == 'B') {
			StringBuffer sb = new StringBuffer(ls);
			ls = sb.reverse().toString();
			ls = ls.substring(0,ls.length()-1);
			
			make(ls);
		}
		
		
	}

}
