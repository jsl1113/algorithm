import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//�ּ��� dfsó�� ������ Ǯ�� �ִµ� �ð��� �ʹ� �����ɷ��� �����ߴ��� 
//�̷��� �̸� �迭�� ���ڸ� �ְ� �ϴٴ�.. �㹫�ϴ�
public class B22251_����ȣ�� {
	
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
		 * ���ڸ� ǥ���ϴ� ��� : 7���� boolean����?
		 * ��� true�̸� ���ڰ� ����. �Ǻ��ϱ�?
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
		 * �̸� ���ڿ��� ���ڷ� �ּ� �� °�� ����� �� �����ϱ�?
		 * 0 1 2 3 4 5 6 7 8 9 
		 * 6 2 5 5 4 5 6 3 7 6 �� �����ִ�.
		 * 
		 * 
		 * 1. ���� �����ִ� ���� ��ġ�� ������ ���Ѵ� . 
		 *     (1�� 2 ) 3�� �ϳ� ��ħ  �Ȱ�ħ : (1�� ��ü �� - ��ģ ��) = 1
		 * 2. (2) (5) 4�� : (5-1) +   1 = 5
		 *    (4)4 (9)6 ��:4 6- 4 =2
		 *    (2)5 (7)3 ��:2 �Ȱ�:3 / (3-2) + 3 = 1+3 = 4
		 *    ���� : (�� �Ҽ� - ��ģ��) + �� �Ҽ��� �Ȱ�ģ��(�� �Ҽ�-��ģ��)  
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
				System.out.println("����" + Arrays.toString(now));
				
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
