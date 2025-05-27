import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//주석과 dfs처럼 열심히 풀고 있는데 시간이 너무 오래걸려서 포기했더니 
//이렇게 미리 배열에 숫자를 넣고 하다니.. 허무하다
public class B22251_빌런호석 {
	
	static int n,k,p,x,ans;

	static int[][] ntn =  {
			{0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
            {4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
            {3, 5, 0, 2, 5, 4, 3, 4, 2, 3},
            {3, 3, 2, 0, 3, 2, 3, 2, 2, 1},
            {4, 2, 5, 3, 0, 3, 4, 3, 3, 2},
            {3, 5, 4, 2, 3, 0, 1, 4, 2, 1},
            {2, 6, 3, 3, 4, 1, 0, 5, 1, 2},
            {3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
            {1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
            {2, 4, 3, 1, 2, 1, 2, 3, 1, 0}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		
		/*
		 * 숫자를 표시하는 방법 : 7개의 boolean으로?
		 * 어떤게 true이면 숫자가 뭐다. 판별하기?
		 * 0 4 3 0 0 0 0 0 0 0
		 * 0 0 0 0 0 0 0 0 0 0
		 * 0 0 0 0 0 0 0 0 0 0
		 * 0 0 0 0 0 0 0 0 0 0
		 * 0 0 0 0 0 0 0 0 0 0
		 * 0 0 0 0 0 0 0 0 0 0
		 * 0 0 0 0 0 0 0 0 0 0
		 * 0 0 0 0 0 0 0 0 0 0
		 * 0 0 0 0 0 0 0 0 0 0
		 * 0 0 0 0 0 0 0 0 0 0
		 * 
		 * 
		 *   2  
		 * 1   3 
		 *   4
		 * 7   5
		 *   6
		 * 
		 * 미리 숫자에서 숫자로 최소 번 째로 만드는 걸 저장하기?
		 * 0 1 2 3 4 5 6 7 8 9 
		 * 6 2 5 5 4 5 6 3 7 6 개 켜져있다.
		 * 
		 * 
		 * 1. 서로 켜져있는 곳이 겹치는 갯수를 구한다 . 
		 *     (1과 2 ) 3번 하나 겹침  안겹침 : (1의 전체 수 - 겹친 수) = 1
		 * 2. (2) (5) 4개 : (5-1) +   1 = 5
		 *    (4)4 (9)6 겹:4 6- 4 =2
		 *    (2)5 (7)3 겹:2 안겹:3 / (3-2) + 3 = 1+3 = 4
		 *    공식 : (뒷 불수 - 겹친수) + 앞 불수의 안겹친수(앞 불수-겹친수)  
		 */
		
		solve(0, 1, 0, 0);
		System.out.println(ans-1);
	}
	
	static void solve(int cnt, int num, int now, int kk ) {
		if(now>n || cnt>p) {
			return;
		}
		
		if(kk == k) {
			if(now!=0) {
				ans++;
			}
			return;
		}
		for(int i=0;i<10;i++) {
			solve(cnt+ntn[x/num%10][i], num*10, now+i*num, kk+1);
		}
	}
	

	static void dfs(int cnt, int[] now, int sum, int until) {
		if(cnt == k) {
			
			if(sum == until) {
				System.out.println("여긴" + Arrays.toString(now));
				
			}
			return;
		}
		
		for(int i=0;i<=until-sum;i++) {
			now[cnt] = i;
			dfs(cnt+1, now, sum+i, until);
		}
	}
	
	static boolean isNum(int[] now) {
		
		for(int i=0;i<k;i++) {
			System.out.println(now[i]+ " /");
		}
		return true;
	}

}
