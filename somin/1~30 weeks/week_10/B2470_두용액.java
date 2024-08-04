package BOJ.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/*
 * ����Ž���� �ƴ϶� �������ͷ� Ǯ����..
 * (���� ó���� dfs�Ϸ��ٰ� �ð��ʰ� ��)
 * 
 */
public class B2470_�ο�� {

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
		 * �̺�Ž��: start end �ΰ��� �� ����̶�� �����ϰ� 
		 * �����ϸ� �Ǵ±���..
		 */
		int start = 0;
		int end = arr.length-1; //n-1
		
		while(start<end) {
			int sum = arr[start] +arr[end];
			//�ּڰ� ����
			if(Math.abs(sum)<zero) {
				zero = Math.abs(sum);
				one = arr[start];
				two = arr[end];
			}
			//���� ����϶�
			if(sum>0) {
				end = end-1;
			}
			else{
				start = start+1;
			}
			
		}
		

		//dfs�� ��� ���� �� ���ؼ� ��ְ� 
		//�� ���� �����ؼ� 0�̶� ���� ����� ���� �̺�Ž������ ���Ѵ�.?
		
		System.out.println(one+" "+two);
		
	}
	//�ΰ��� ���ؼ� �� �����
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
