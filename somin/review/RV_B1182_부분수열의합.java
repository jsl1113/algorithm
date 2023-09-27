package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class RV_B1182_부분수열의합 {

	static int n,s;
	static int[] arr;
	static boolean[] isVisited;
	static int ans=0;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		isVisited = new boolean [n];
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
//		dfs(0 );
//		System.out.println(ans);
		
		//비트마스킹으로 풀어보기~
		/*
		 *  for (int j = 0; j < n; j++) {  // i 가 5(101)일 때,  0 ~ 6까지 수 중에서,
                // j = 0 : 101 & 001 = 1 -> 1은 start
                // j = 1 : 101 & 010 = 0 -> 2는 link
                // j = 2 : 101 & 100 = 4 -> 3은 start
                // j = 3 : 0101 & 1000 = 0 -> 4는 link
                // j = 4 : 00101 & 10000 = 0 -> 5는 link
                // j = 5 : 000101 & 100000 = 0 -> 6은 link
                // start: 1,3, link: 2,4,5,6
                if ((i & 1 << j) != 0) startList.add(j + 1);
                else linkList.add(j + 1);
            }
		 */
		int cnt=0;
		for(int mask=1;mask<Math.pow(2, n);mask++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			for(int i=0;i<n;i++) {
				if((mask & (1<<i))!=0) {
					list.add(arr[i]);
				}
			}
			int tmp=0;
			for(int j:list) tmp+=j;
			if(tmp ==s) cnt++; 
			
		}
		
		System.out.println(cnt);
		
	}
	
	
	
	public static void dfs(int cnt ) {
		if(cnt ==n) {
			int sum=0;
			int ck=0;
			for(int j=0;j<n;j++) {
				if(isVisited[j]) {
					System.out.print(arr[j]+" ");
					sum+= arr[j];
					ck++;
				}
			}
			System.out.println("-----"+sum);
			
			if(ck>0 && sum == s) {
				ans++;
				System.out.println(sum+" "+ans);
			}
			return;
			
		}
		
		isVisited[cnt] = true;
		dfs(cnt+1);
		
		isVisited[cnt] = false;
		dfs(cnt+1);
		
		
	}

}
