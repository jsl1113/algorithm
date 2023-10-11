package BOJ.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * �̺�Ž��.. ���� ��Ǯ������
 * ���� �˾Ҵ�.
 * ó���� max+1�� ���ִ� �� ������� ���� Ʋ�� �����ε�
 * min�� 0�̿��� ~�䷱���� ����������..
 * 
 * ���� max�� ���� �� �ִ밪�� �ƴ� ������ ��ü��/k�� �ؼ� Ǯ������ Ʋ�ȴ�. 
 */
public class B1654_�����ڸ��� {

	static int n,k;
	static int[] lan;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		lan = new int[k];
		
		long max = 0;
		for(int i=0;i<k;i++) {
			lan[i] = Integer.parseInt(br.readLine());
			if(max<lan[i])max = lan[i];
		}
		max++;
		
		long min=0;
		while(min<max) {
			long mid = (min+max)/2;
			
			long cnt=0;
			for(int i=0;i<k;i++) {
				cnt+=lan[i]/mid;
			}
			
			if(cnt<n) {
				max = mid;
			}
			else {
				min = mid+1;
			}
	
			
		}
		System.out.println(min-1);
	}


}
