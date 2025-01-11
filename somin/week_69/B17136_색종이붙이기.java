import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17136_�����̺��̱� {

	
	static int[][] map = new int[10][10];
	static boolean[][] visit = new boolean[10][10];
	static int[] nums  = new int[5];
	static int ans=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());

		for(int i=0;i<10;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<10;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		/*
		 * 0,0 ���� n,n���� dfs
		 * 
		 * n n �̸� return
		 * 
		 * ���簡 0 �Ǵ� ���簡 �پ��ִ� ���̸� ����ĭ���� �̵�
		 * 	�ƴϸ�
		 * ������ ���̱� (1~5������ ������)
		 * 	**���� �� ������?
		 *      ���̰� ����ĭ	
		 * 		��ƼĿ ����
		 *  ** 
		 */
		
		dfs(0, 0);
		System.out.println(ans==Integer.MAX_VALUE?-1:ans);
	}
	
	
	static void dfs(int depth, int cnt) {
		
		if(depth == 100) {
			ans = Math.min(ans, cnt);
			return;
		}
		
		int r = depth / 10;
		int c = depth % 10;
		
		if(map[r][c] == 0 || visit[r][c]) {
			dfs(depth+1, cnt);
		}else {
			for(int i=1;i<=5;i++) {
				if(check(r, c, i, true)) {
					dfs(depth+1, cnt+1);
					check(r, c, i, false);
				}
			}
		}
		
		
	}
	
	static boolean check(int r, int c, int size, boolean flag) {
		if(flag) {
			if(nums[size-1]==5) {
				return false;
			}
			//���� �� �ִ��� Ȯ��
			for(int i=r;i<r+size;i++) {
				for(int j=c;j<c+size;j++) {
					if(i>=10 || j>=10 ||visit[i][j] || map[i][j] ==0) {
						return false;
					}
				}
			}
			
			nums[size-1]++;
		}else { //������ ���� ���� (����)
			nums[size-1]--;
		}
		
		for(int i=r;i<r+size;i++) {
			for(int j=c;j<c+size;j++) {
				visit[i][j] = flag;  // 
			}
		}
		
		
		return true;
	}

}
