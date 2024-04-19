package BOJ.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * ����Ž���� ��������
 * BinarySearch(x,y) ���� (y���� �����ֵ�) - (x���� ���� �ֵ�) 
 *  �ؼ� ���� ������ ���ٴ� ������ ���ߴ�. 
 *  ����Ž�� ���ΰ� �ʿ��ҵ�. �ٵ� ����Ž���� �ð� �ʹ� �����ɸ��� �� �ƴѰ�..?
 */
public class B11663_���������� {

	static int n,m;
	static int []pointN;
	static int[][] line;
	static int[] arr;
	static ArrayList<Integer> arrlst;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		pointN = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			pointN[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(pointN);
	
		line = new int[m][2];
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			line[i][0] = a;
			line[i][1] = b;
			sb.append(binarySearch(a, b)+"\n");

		}
		System.out.println(sb);
		
	}
	public static int binarySearch(int x, int y	) {
		
		int start = 0;
		int end = pointN.length-1;
		
		//y��ǥ���� ���� pointN�� ����
		while(start<=end) {
			int mid = (start+end)/2;
			if(pointN[mid]>y) {
				end = mid-1;
			}else
				start = mid+1;
		}
		
		int endidx = end+1;
		
		start=0;
		end=pointN.length-1;
		
		//x��ǥ���� ���� pointN�� ����
		while(start<=end) {
			int mid = (start+end)/2;
			if(pointN[mid]<x) {
				start = mid+1;
			}else
				end = mid-1;
		}
		int startidx = start;
		
		return endidx-startidx;
	}
	


}
