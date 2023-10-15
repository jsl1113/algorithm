package BOJ.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/*
 * 이진탐색이 아니라 투포인터로 풀었다..
 * (물론 처음엔 dfs하려다가 시간초과 ㅎ)
 * 
 */
public class B2470_두용액 {

	static int n;
	static int[] arr;
	
	static int[] num= new int [2];
	
	static int zero = Integer.MAX_VALUE;
	static int one;
	static int two;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
		
		/*
		 * 이분탐색: start end 두개를 두 용액이라고 생각하고 
		 * 덧셈하면 되는구나..
		 */
		int start = 0;
		int end = arr.length-1; //n-1
		
		while(start<end) {
			int sum = arr[start] +arr[end];
			//최솟값 갱신
			if(Math.abs(sum)<zero) {
				zero = Math.abs(sum);
				one = arr[start];
				two = arr[end];
			}
			//합이 양수일때
			if(sum>0) {
				end = end-1;
			}
			else{
				start = start+1;
			}
			
		}
		

		//dfs로 모든 합을 다 구해서 써넣고 
		//그 합을 정렬해서 0이랑 제일 가까운 술를 이분탐색으로 구한다.?
		
		System.out.println(one+" "+two);
		
	}
	//두개를 더해서 합 만들기
	public static void dfs(int idx,int cnt) {
		if(cnt==2) {
			int sum = arr[(int) num[0]] +  arr[(int) num[1]];
//			System.out.println(sum+" // "+arr[(int) num[0]] 
//					+" / "+ arr[(int) num[1]]);

			if(zero>Math.abs(sum)) {
				zero = Math.abs(sum);
				one = arr[(int) num[0]];
				two = arr[(int) num[1]];
			}

			return;
		}
		for(int i=idx;i<n;i++) {
			num[cnt] = i;
			dfs(i+1, cnt+1);
		}
	}
	


}
