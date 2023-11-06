package BOJ.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B5639_이진검색트리 {

	static ArrayList<Integer> list = new ArrayList<Integer>();
	static int[][] tree;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int max = 0;
		int len=0;
		while(s!=null&& s!="") {
			list.add(Integer.parseInt(s));
			max = Math.max(max, Integer.parseInt(s));
			len++;
			s = br.readLine();
		}
		
		post(0, len-1);
//		
//		System.out.println(list);
	}
	public static void post(int n, int end) {
		
		if(n>end) {
			return;
		}
		
		int mid = n+1;
		while(mid<=end &&list.get(mid)<list.get(n)) {
			mid++;
		}
		
		post(n+1, mid-1);
		post(mid, end);
		System.out.println(list.get(n));
		
	}
	
}
