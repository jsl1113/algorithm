package BOJ.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// ���� init�� �����غþ� ^_^
/*
 * �ڲ� ���翡�� �������� ���ؼ� ū�� ������ �񱳷� �Ϸ��ϱ� �𸣰ڰ� ������ �񱳴� ��� ����? �ߴ�
 * --
 * ������ġ�� 1~w-1���� (0�� w�� ���� ä���� �� ����)
 * ���� ��ġ �������� ���� ���������� ������ ���ʰ� �������� �ִ��� ���Ѵ�.
 * �� �� �� ���� ������ ���� ���̸� ���� (�ٵ� �� ���� �����̸� 0)
 * �� ���� ���س����� �ȴ� 
 */
public class B14719_���� {

	static int h,w;
	static int[] list;
	static int ans=0;
	public static void main(String[] args) throws IOException {
		init();
		sol();
	}

	static void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		
		list = new int[w];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<w;i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
	}
	static void sol() {
		for(int i=1;i<w-1;i++) {
			int left=0; int right=0;
			for(int j=0;j<i;j++) { //���ʺ��� i���� �ִ�
				left = Math.max(left, list[j]);
			}
			for(int j=i+1;j<w;j++) { //i+1���� ������ �ִ�
				right = Math.max(right, list[j]);
			}
			//�� �� �� �� ���� ��� ũ�⸸ŭ ���� ����
			int t = ( Math.min(left, right) - list[i]<0) ? 0 :Math.min(left, right) - list[i];
			ans+=t;
			
		}
		System.out.println(ans);
	}
}
