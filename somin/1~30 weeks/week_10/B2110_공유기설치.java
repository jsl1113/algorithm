package BOJ.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * ���� Upper Bound�� Lower Bound�� �𸣰ڴ�..
 * ������ ���� �Ÿ��� mid�� �����ؼ� ���� �Ÿ��� mid�϶� ������ ������ ī��Ʈ �ؼ� 
 * �׿� ���� ������ c���� ������ mid�� �۰��ϰ� 
 * ������ c �̻��̸� �ּҰŸ��� �÷��༭ 
 * ������ �����ϴ� �ִ� �Ÿ��� �˾Ƴ� �� �־���..
 * �������� s-1 ���ִ� ���� Upper Bound�� Ž�� ���� �ʰ��ϴ� ù��° ���� ����Ű�� �����̴�.
 */
public class B2110_�����⼳ġ {

	static int n,c;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		int s = 1;
		int e = arr[n-1] - arr[0] +1;
		
		while(s<e) {
			int mid = (s+e)/2;
			
			//mid �Ÿ���ŭ ���� ��ġ�� ������ c�� �̸��̸� mid�Ÿ��� �۾�������
			if(install(mid)<c) {
				e = mid;
			}
			else { //mid�Ÿ� ��ŭ ���� ��ġ�� ������ c�̻��̸� mid�� Ű������
				//�ּҰŸ��� ���� �� �ִ� �ִ�Ÿ��� ã�Ƴ���..
				s = mid+1;
			}
		}
		
		System.out.println(s-1);
		
	}
	public static int install(int mid) {
		//1��° ���� ��ġ�Ǿ���
		int cnt=1;
		int lastLocate = arr[0];
		
		
		for(int i=1;i<n;i++) {
			int locate = arr[i];
			
			//�� ������ ���� ���� �Ÿ� ���̰� mid �̻��϶��� cnt++�ϰ� ������ ����
			if(locate- lastLocate >=mid) {
				cnt++;
				lastLocate = locate;
			}
			//���� ������ �Ÿ����̰� mid���� ������ ������ ��ġ������ �ȵż� �Ѿ����
		}
		
		return cnt;
	}

}
