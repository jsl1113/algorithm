package BOJ.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class B2531_»∏¿¸√ π‰ {

	static int n,d,k,c;
//	static int[] arr;
	static ArrayList<Integer> arr = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
//		arr = new int[n+k];
		for(int i=0;i<n;i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
//		System.out.println(Arrays.toString(arr));
		
		for(int i=0;i<k;i++) {
			arr.add(arr.get(i));
		}
		
//		System.out.println(Arrays.toString(arr));
		int ans =0;
		int s = 0;
		int e = k-1;
		Set<Integer> list = new HashSet<Integer>();
		ArrayList<Integer> all = new ArrayList<Integer>();
		for(int i=0;i<k;i++) {
			list.add(arr.get(i));
			all.add(arr.get(i));
		}
		while(true) {
			if(!list.contains(c)) {
				ans = Math.max(ans, list.size()+1);
			}else {
				ans = Math.max(ans, list.size());
			}
			all.remove(arr.get(s));
			s++;
			e++;
			all.add(arr.get(e));
			list = new HashSet<Integer>(all);
//			System.out.println(all+" /" +list);
			if(e == arr.size()-1) break;
		}
		
		System.out.println(ans);
		
		
	}

}
