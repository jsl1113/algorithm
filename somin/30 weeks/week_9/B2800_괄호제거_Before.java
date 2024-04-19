package BOJ.data_structure;
/*
 * 이상하고 복잡한 코드다. 보지마시오 [경고]
 * 괄호를 짝지어서 하는 것이 아니라 개개인으로 취급하고 문제를 풀었다. 
 * 아마 그런 문제였으면 맞았을지도? 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class B2800_괄호제거_Before {

	static String s;
	static int cnt=0;
	static String[] list;
	
	static boolean [] isdelete;
	static boolean [] isVisited;
	
	static ArrayList<Integer> left = new ArrayList<>();
	static ArrayList<Integer> right= new ArrayList<>();
	static ArrayList<String> ans= new ArrayList<>();
	
	
	static ArrayList<Integer>[] check;
	static int c=0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s = br.readLine();
		
		isdelete = new boolean[s.length()];
		
		list = s.split("");
		
		System.out.println(list);
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='(') {
				left.add(i);
				isdelete[i] = true;
			}
			else if(s.charAt(i)==')') {
				right.add(i);				
				isdelete[i] = true;
				
			}
		}
		cnt = left.size();
		//모든 괄호쌍 제거
		String ss="";
		for(int i=0;i<s.length();i++) {
			if(!isdelete[i]) {
				ss += list[i];
			}
		}
		ans.add(ss);
		
		isdelete = new boolean[s.length()];
		
		System.out.println(left);
		System.out.println(right);

		
		check = new ArrayList[cnt];
		
		for(int i=0;i<cnt;i++) {
			isVisited = new boolean[cnt];
			for(int j=0;j<cnt;j++) check[j] = new ArrayList<Integer>();
			c=0;
			d(0,0,i+1);
			
			int[] ne = new int[2];
			isdelete = new boolean[s.length()];
			solve(c, 0, ne);
		}
		
		System.out.println(ans);
		Collections.sort(ans);
		System.out.println(ans);
		
		
		
	}
	
	public static void solve(int c, int ck, int[] ne) {
		if(ck==2) {
			for(int i: check[ne[0]]) {
				isdelete[right.get(i)] = true;
			}
			for(int i: check[ne[1]]) {
				isdelete[left.get(i)] = true;
			}

			String st="";
			for(int k=0;k<s.length();k++) {	
				if(!isdelete[k]) {
					st += list[k];
				}
			}
			if(!ans.contains(st)) ans.add(st);
			
			isdelete = new boolean[s.length()];
			return;
		}
		for(int i=0;i<c;i++) {
			ne[ck] = i;
			solve(c, ck+1, ne);
		}
		
	}
	
//	public static void dfs() {
//		
//		for(int i=0;i<cnt;i++) {
//			isdelete[left.get(i)] = true;
//			for(int j=0;j<cnt;j++) {
//				isdelete[right.get(j)] = true;
//				
//				String st ="";
//				for(int k=0;k<s.length();k++) {	
//					if(!isdelete[k]) {
//						st += list[k];
//					}
//				}
//				if(!ans.contains(st)) ans.add(st);
//				System.out.println(ans);
//				
//				isdelete[right.get(j)] = false;
//			}
//			isdelete[left.get(i)] = false;
//		}
//		
//	}
	
	//cnt개의 부분집합을 구한다 치고
//	public static void name(int ck) {
//		
//		if(ck==cnt) {
//			int count=0;
//			for(int i=0;i<cnt;i++) {
//				if(isVisited[i]) {
//					System.out.print(i+1+" ");
//					count++;
//				}
//			}System.out.println();
//			
//			
//			return;
//		}
//		
//		isVisited[ck] = true;
//		name(ck+1);
//		
//		isVisited[ck] = false;
//		name(ck+1);
//	
//	}
	
	public static void d(int ck, int idx, int a) {
		
		if(ck==a) {
			for(int i=0;i<cnt;i++) {
				if(isVisited[i]) {
//					System.out.print(i+1+" ");
					check[c].add(i);
				}
			}
//			System.out.println();
			c++;
			
			return;
		}
		
		for(int i=idx;i<cnt;i++) {
			if(!isVisited[i]) {
				isVisited[i] =true;
				d(ck+1,i+1,a);
				isVisited[i] =false;
			}
		}
	
	}

}
