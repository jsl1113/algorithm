package BOJ.union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 부모를 진실을 알고싶어하는 사람으로 하려고 했더니 됨..
 * 어렵다 생각보다
 */
public class B1043_거짓말 {

	static int n,m;
	static int[] parents;
	static ArrayList<Integer> [] partylst;
	static ArrayList<Integer> knowlst = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		parents = new int[n+1];
		for(int i=1;i<n+1;i++) {
			parents[i]=i;
		}
		
		String [] know = br.readLine().split(" ");  
		int knowCnt = Integer.parseInt(know[0]);		
		for(int i=1;i<know.length;i++) {
			knowlst.add(Integer.parseInt(know[i]));
		}
			
		
		partylst = new ArrayList[m];
		for(int i=0;i<m;i++) partylst[i] = new ArrayList<Integer>();
		
		for(int i=0;i<m;i++) { 
			st = new StringTokenizer(br.readLine());
			int partyCnt = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());
			partylst[i].add(f);
			for(int j=1;j<partyCnt;j++) {
				int next = Integer.parseInt(st.nextToken());
				partylst[i].add(next);
				union(f, next);
				f = next;
			}
		}
//		System.out.println(Arrays.deepToString(partylst));
//		System.out.println(Arrays.toString(parents));
		
		int cnt =0;
		for(int i=0;i<m;i++) {
			boolean flag = true;
			for(int j : partylst[i]) {
				if(knowlst.contains(find(parents[j]))) {
					flag = false;
					break;
				}
			}
			if(flag) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
		
	}
	public static int find(int a) {
		if(parents[a]==a) return a;
		
		return find(parents[a]);
	}
	public static void union(int a, int b) {
		int A = find(a);
		int B = find(b);
		if(A!=B) {
			if(knowlst.contains(B)) {
				parents[A] = B;
			}else {			
				parents[B] = A;
			}
			
		}
	}

}
