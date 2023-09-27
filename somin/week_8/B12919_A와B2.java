package BOJ.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*
 * t에서 하나씩 빼면서 s를 만들어가는 방법이 시간초과가 안난다.
 * s에 하나씩 더하는 건 너무 시간초과다.... 바보
 */
public class B12919_A와B2 {

	static String s,t;
	static int len;
	static boolean[] isVisited;
	static boolean ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		s = bf.readLine();
		t = bf.readLine();
		
		len = t.length()-s.length();
		
		isVisited= new boolean[len];
		dfs2(t);
		if(ans==true) System.out.println(1);
		else
			System.out.println(0);
	}
	
	public static void dfs2(String str) {
//		System.out.println(str);
		
		if(str.length()==s.length()) {
			if(str.equals(s)) {
				ans = true;
				return;
			}
			return;
		}
		//맨뒤가 A일 경우
		if(str.charAt(str.length()-1) =='A') {
//			System.out.println("a");
			dfs2(str.substring(0, str.length()-1));
		}
		
		//맨앞이 B일경우
		if(str.charAt(0)=='B') {
//			System.out.println("b");
			String ss = str.substring(1);
			StringBuilder sb = new StringBuilder(ss);
			str = sb.reverse().toString();
			dfs2(str);
		}
	}
	
	//a와 b를 가지고 len길이만큼 줄세우기
	// aaa aab aba ...
	public static void dfs(int cnt) {
		if(ans == true) return;
		if(cnt ==len) {
			ArrayList<String> list = new ArrayList<String>();
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<len;i++) {
				if(isVisited[i]) {
//					System.out.print("a");
					list.add("a");
				}
				else {
//					System.out.print("b");
					list.add("b");
				}
			}
//			System.out.println();
			if(make(list)) {
				ans = true;
				return;
			}
			return;
		}

		
		isVisited[cnt]= true;
		dfs(cnt+1);
		
		isVisited[cnt]= false;
		dfs(cnt+1);
		
	}
	
	public static boolean make(ArrayList<String> list) {
		String ans= s;
		for(String al : list) {
			if(al=="a") {
				ans = ans + "A"; 
//				System.out.println(ans);
			}
			if(al=="b") {
				
				ans = ans + "B";
				StringBuffer sb = new StringBuffer(ans);
				ans = sb.reverse().toString();
//				System.out.println(ans);
			}
			
		}
		
//		System.out.println("완료: "+ans);
		if(ans.equals(t)) {
//			System.out.println("꺄~"); 
			return true;
		}
		else 
			return false;
	}

}
