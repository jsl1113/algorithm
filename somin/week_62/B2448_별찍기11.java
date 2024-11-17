import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//너무 머리가 안돌아가서 .. 포기 재귀로 제일 작은 삼각형으로 올 때까지 반복이였다..
public class B2448_별찍기11 {

	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		map = new char[n][n*2-1];

		for(int i=0;i<n;i++) {
			Arrays.fill(map[i], ' ');
		}
		
		star(0,n-1,n);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n*2-1;j++) {
				sb.append(map[i][j]);
			}sb.append("\n");
		}
		
		System.out.println(sb);
	}
	static void star(int r, int c, int n) {
		if(n == 3) {  //가장 작은 삼각형
			map[r][c] = '*';
			map[r+1][c-1] = map[r+1][c+1] = '*';
			for(int i=-2;i<3;i++) {
				map[r+2][c+i] = '*';
			}
			return;
		}else {
			int slice = n/2;
			star(r,c, slice);   //제일 위
			star(r + slice, c -slice , slice);  //아래 왼쪽
			star(r + slice, c +slice , slice);  //아래 오른쪽
		}
	}
}
