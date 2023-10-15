package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class RV_B16508_전공책 {

	static int[] ans, cntBook;
	static int n;
	static Book[] books;
	static int result= Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String t = br.readLine();
		ans = new int[26];
		cntBook = new int[26];
		for(int i=0;i<t.length();i++) {
			ans[t.charAt(i)-'A']++;
//			System.out.println(t.charAt(i)-'A');
		}
		
		n = Integer.parseInt(br.readLine());
		
		books = new Book[n];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			books[i] = new Book(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		dfs(0,0,0);
		if(result == Integer.MAX_VALUE) System.out.println(-1);
		else
			System.out.println(result);
		
	}
	//부분집합..
	public static void dfs(int idx, int cnt, int total) {
		if(cnt == n) {
			if(check()) {
				result = Math.min(total, result);
				
			}
			return;
		}
		for(int i=0;i<books[idx].name.length();i++) {
			cntBook[books[idx].name.charAt(i)-'A']++;
		}
		dfs(idx+1,cnt+1,total+books[idx].price);
		
		for(int i=0;i<books[idx].name.length();i++) {	
			cntBook[books[idx].name.charAt(i)-'A']--;
		}
		dfs(idx+1,cnt+1,total);
	}
	
	//
	public static boolean check() {
		//ans의 각 개수보다 cnt의 각 개수가 하나라도 작으면 거짓  
		for(int i=0;i<26;i++) {
			if(cntBook[i]<ans[i]) {
				return false;
			}
		}
		return true;
	}
	public static class Book {
		int price;
		String name;
		Book(int price, String name){
			this.name = name;
			this.price = price;
		}
	}

}
