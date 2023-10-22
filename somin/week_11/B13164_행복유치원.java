package BOJ.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B13164_�ູ��ġ�� {

	static int n,k;
	static int[] height;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		height = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		/*
		 * 5 3
		 * 1 3 5 6 10
		 *  2 2 1 4
		 * 
		 * �ƴ� ������ .. k���� ���ε� ��� ������ �� �־���ϳ�? 
		 * ���� �� ������ ��������. (�ּҰ��� �Ѱ��ϱ� �װ� 0���� �ļ�)
		 * 3���߿� 1���� ȥ�ڶ�� �ļ� -> 2�� ���� +0 �ϴ� ����?
		 * 
		 * 1 3 5 6 10 13
		 *  2 2 1 4  3
		 * 1356 10 13 
		 * 
		 */
		int [] diff = new int[n-1];
		
		for(int i=0;i<n-1;i++) {
			diff[i] = height[i+1]-height[i];
		}

		Arrays.sort(diff);
		int sum=0;
		for(int i=0;i<n-k;i++) {
			sum+= diff[i];
		}
		System.out.println(sum);
	}


}
