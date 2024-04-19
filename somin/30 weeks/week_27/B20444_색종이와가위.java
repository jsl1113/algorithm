import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
/*
 * BufferedReader StringTokenizer 대신 Scanner 쓰니까 런타임에러 해결 ;
 * 
 * 여기서는 가로로 자르기 세로로 자르기를 생각해서 가로 기준으로 +1 -1 하는 방법
 */
public class B20444_색종이와가위 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		
		
		long n = sc.nextInt();
		long k = sc.nextLong();
		
		long s = 0;
		long e = n/2; //가로로 자른 횟수 == 세로로 자른 횟수
		
		
		while(s<=e) {
			
			long mid = (s+e)/2;
			
			//가로로 자른 횟수 + 세로로 자른 횟수 = n
			
			long vert  = n - mid; //세로 
			
			// 조각 갯수 세기 
			long pieces = (mid+1)*(vert+1);
			
			if(pieces == k) {
				System.out.println("YES");
				return;
			}else if(pieces > k) { //조각이 많다 줄여
				e = mid -1;
			}else {   //조각이 적다 늘리기
				s = mid +1; 
			}
			
		}
		System.out.println("NO");
		
	}

}
