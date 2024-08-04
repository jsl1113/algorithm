package BOJ;
/*
 * 해결 실패 
 * dp 점화식을 생각을 절대 못했다. 생각치도 못한 공식....
 * 계속 완전탐색을 생각했는데 너무 효율적이지 않아서 고민하다가 포기
 * 정답은 점화식을 알아내는 것.
< 정답 보기 전 >
일단  n까지의 제곱한 수를 넣은 배열을 가지고 dfs해야할 것 같다
갑자기 생각난건데 list의 원소중에 1개를 선택해서 합을 만드는 거 2개 선택..
문제는 중복해서 만드는거네..
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B17626_FourSquares {

	static ArrayList<Integer> list= new ArrayList<Integer>();
	static int [] dp;
	static int sum=0;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int ans=0;
		dp = new int[n+1];
		
		dp[0]=0;dp[1]=1;
		pow(n);
		System.out.println(dp[n]);
	}
	
	public static void pow(int n) {
		for(int i=2;i<=n;i++) {
			int min = Integer.MAX_VALUE;
			for(int j=1;j*j<=i;j++) {
//				System.out.println(i+" "+j);
//				System.out.println(" dp["+(i-j*j)+"]= "+dp[i-j*j]);
				min = Math.min(min, dp[i-j*j]);
			}
			dp[i] = min+1;
		}
		
	}

}
