package BOJ.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
/*
 * ��� ���� ���ذ� �ȵż� Ǯ���� ������.
 * ���ݵ� ���ظ� �ϰ� �ִ��� Ȯ���� ����.
 * https://codingrapper.tistory.com/193
 * �̰ɺ��� ��¦ �����ߴµ� �� �ﰢ������ ���Ǹ� �𸣰ڵ�... 
 */
public class B1548_�κлﰢ���� {

	static int n;
	static int[] a;
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(bf.readLine());
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		a = new int[n];
		
		for(int i=0;i<n;i++) {
			a[i] = Integer.parseInt(st.nextToken());
			
		}
		Arrays.sort(a);
	
		int min = 1;
		if(n>2) {
			for(int i=0;i<n-1;i++) {
				for(int j=n-1;j>=0;j--) {
					if(i+1 ==j) break;
					
					if(a[i]+a[i+1]>a[j]) {
						min = Math.max(min, j-i+1);
						break;
					}
					
				}
			}
		}
		if(min ==1 && n>=2) min =2;
		
		System.out.println(min);
		
		//���̰� 2 �����̸� �׻� �ﰢ�����̴�.
		
	}

}
