import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class B2668_숫자고르기 {

	static int n;
	static int[] arr;
	static ArrayList<Integer> list [];
	
	static boolean[] visit;
	static ArrayList<Integer> ans = new ArrayList<Integer>();
	
	static ArrayList<Integer> result = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		arr = new int[n+1];
		list = new ArrayList[n+1];
		for(int i=0;i<n+1;i++) list[i] = new ArrayList<Integer>();
		
		visit = new boolean[n+1];
		
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
//		System.out.println(Arrays.toString(arr));
		
		
		for(int i=1;i<=n;i++) {
			visit = new boolean[n+1];
			
			dfs(i, i);
			
			
		
		}
		Collections.sort(ans);
		System.out.println(ans.size());
		for(int aa : ans) {
			System.out.println(aa);
		}
		
	}
	

	static void dfs(int num , int first) {
		if(first==arr[num]) {
			
			ans.add(num);
			return;
			
		}
		
		visit[num] = true;
		
		if(!visit[arr[num]]) {
			dfs(arr[num], first);
		}
		visit[num] = false;
	}
	
	
	

}
