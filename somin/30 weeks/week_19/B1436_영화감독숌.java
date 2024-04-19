package BOJ.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B1436_¿µÈ­°¨µ¶¼ò {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		int num = 665;
		while(true) {
			
			num++;
			
			String str = Integer.toString(num);
			if(check(str)) {
				cnt++;
			}
			
			if(cnt==n) break;
			
		}
		System.out.println(num);
		
	}
	
	public static boolean check(String str) {
		if(str.contains("666")) {
			return true;
		}else
			return false;
		
	}

}
