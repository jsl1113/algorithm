package BOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/*
 * ���ø� �־������� ���� ���Դµ� 
 * " �� �� �� �� �� " �� �� ��
 */
public class B10844_�����ܼ�_Before {

	static ArrayList<Integer>[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		arr = new ArrayList [n+1];
		for(int i=0;i<n+1;i++) {
			arr[i] = new ArrayList<>();
		}

		for(int i=1;i<10;i++) arr[1].add(i);
		
		for(int i=1;i<n;i++) {
//			System.out.println(i+"��°");
			for(int x :arr[i]) {
				if(x == 0) {
					arr[i+1].add(1);
				}
				else if(x == 9) {
					arr[i+1].add(8);
				}
				else {
					arr[i+1].add(x-1);
					arr[i+1].add(x+1);
//					System.out.println("���� x= "+ x);
				}
			}
		}
		
//		System.out.println(Arrays.deepToString(arr));

		System.out.println(arr[n].size()%1000000000);

		
	}
	

}
