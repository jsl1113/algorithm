package BOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/*
 * 예시를 넣었을때는 답이 나왔는데 
 * " 메 모 리 초 과 " 대 실 패
 */
public class B10844_쉬운계단수_Before {

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
//			System.out.println(i+"번째");
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
//					System.out.println("엘스 x= "+ x);
				}
			}
		}
		
//		System.out.println(Arrays.deepToString(arr));

		System.out.println(arr[n].size()%1000000000);

		
	}
	

}
