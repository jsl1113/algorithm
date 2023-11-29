package BOJ.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 끝과 처음이 이어져 있다는 것을 잘 이용해서 나머지연산을 하기..
 */
public class B1522_문자열교환 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String arr = br.readLine();
		
		int a = 0;
		
		for(int i=0;i<arr.length();i++) {
			if(arr.charAt(i)=='a')a++;
		}

//		System.out.println(a);
		int ans = arr.length();
		for(int i=0;i<arr.length();i++) {
			int b = 0;
			for(int j=i;j<a+i;j++) {
				if(arr.charAt(j%arr.length())=='b') {
					b++;
				}
			}
			ans = Math.min(ans, b);
		}
		
		System.out.println(ans);

	}

}
