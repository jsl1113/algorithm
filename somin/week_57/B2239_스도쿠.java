import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 해맨 부분 : 
 * 1. arr가 0인 경우가 없다를 10,10을 출력해 10일 때 system.exit(0)을 하는 아이디어
 * 2. 중복인지 아닌지 체크하고 arr[i][j]= num 아랫줄에 재귀로 들어가는 부분.
 * 
 * 느낀점 : 오랜시간을 썼지만 재귀라는 생각을 안하고 중복체크만 열심히 했다.바보.
 */
public class B2239_스도쿠 {

	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = new int[9][9];
		
		for(int i=0;i<9;i++) {
			String s = br.readLine();
			for(int j=0;j<9;j++) {
				arr[i][j] = s.charAt(j)-'0';
				if(arr[i][j] ==0) {
				}
			}
		}
		
		check();
		
	}
	
	static void print() {
		for (int[] aa : arr) {
			for (int a : aa) {
				System.out.print(a);
			}
			System.out.println();
		}
	}
	
	static int[] find() {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(arr[i][j] ==0) {
					return new int[]{i,j};
				}
			}
		}
		return new int[] {10,10};
	}
	
	static void check() {
		int x = find()[0];
		int y = find()[1];
		
		if(x == 10) {
			print();
			System.exit(0);
		}
		
		for(int i=1;i<=9;i++) {
			int num = i;
			
			if(isDuplicate(x, y, num)) {
				arr[x][y] = num;
				check();
				arr[x][y] = 0;
			}
		}
	}
	
	static boolean isDuplicate(int x, int y, int num) {
		
		//세로 가로 체크
		for(int i=0;i<9;i++) {
			if(arr[i][y] == num || arr[x][i] ==num) {
				return false;
			}
		}
		
		//네모 체크
		//012 345 678 
		int sx = (x/3)*3;
		int sy = (y/3)*3;
		
		for(int i=sx;i<sx+3;i++) {
			for(int j=sy;j<sy+3;j++) {
				if(arr[i][j] == num) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	
	
}
