import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* 
 * �ʹ� ���� ����� ���� ��� ����ؾ��ϴ��� ������� ����.
 * ����� ��Ʈ��ŷ+dfs��������... ���������� ������ �� �������?
 * 
 * 0 : ��ĭ
 * 1~5 : cctv��ȣ
 * 6 : �� 
 * 
 * ��: 
 * cctv�� ���� ������ ��� ��츦 dfs�� Ž���ϰ� 
 * cctv�� ��ġ�� lst�� ����
 * cctv�� ������ 2�����迭 cctvs�� ���� 
 * 		-> 1,2,3,4,5���� ���� ������ 0,1,2,3���� �̸� �����س��� 
 * 			-> �̰� 4�������� �����鼭 üũ
 * 			= for���� 4�������� ������ (i)�� ���ϰ� %4���༭ ������ 0,1,2,3 �߿� ������ ��
 * dfs����� return�� �ֱ� ������ map�� �ǵ����� ���� copy�Լ��� ����� �����
 * ��� cctv�� �� üũ�ϸ� ���� map�� 0�� ���� ����
 *  
 */
public class B15683_���� {

	static int n,m;
	static ArrayList<CCTV> lst = new ArrayList<>();
	static int minAns = Integer.MAX_VALUE;
	static int[][] move = { //�����¿�� �̵�
			{0,1}, 
			{1,0},
			{0,-1},
			{-1,0}
	};
	static int[][] cctvs = {
			{},
			{0},       // ��
			{0,2},     // ����
			{0,1},     // ���
			{0,1,2},   // �����
			{0,1,2,3}  // �������
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[][] arr =new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]>0 && arr[i][j]<6) {
					lst.add(new CCTV(i, j, arr[i][j]));
				}
			}
		}
		
		//����� �� üũ
		dfs(0, arr);
		System.out.println(minAns);
	}
	
	static void dfs(int cnt, int[][] map) {
		if(cnt == lst.size()) { //��� cctv üũ��
			//0���� ����
			
			minAns = Math.min(minAns, countZero(map));
			return;
		}
		
		//cnt��° cctv�� ���� ���ϱ�
		int x = lst.get(cnt).x;
		int y = lst.get(cnt).y;
		int num = lst.get(cnt).num;
		for(int i=0;i<4;i++) { //4�������� ������
			int[][] newMap = copy(map); //�����ؼ� ��������
			for(int c : cctvs[num]) {  //num�� cctv  
				int dir = (c+i)%4; //
				
				int nx = x;
				int ny = y;
				
				while(true) {
					nx += move[dir][0];
					ny += move[dir][1];
					
					//���� �����ų� 6�� ������ out
					if(nx<0 || nx >=n ||ny<0 || ny>=m || map[nx][ny]==6) {
						break;
					}
					newMap[nx][ny] = -1; //������ ��
				}
			}
			//�̹� cctv ������ ���� �ŷ�
			dfs(cnt+1, newMap);
			
		}
	}
	
	static int[][] copy(int[][] map){
		int[][] cpm = new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				cpm[i][j] = map[i][j];
			}
		}
		
		return cpm;
		
	}
	
	
	
	//0�� ���� ���� = ans
	static int countZero(int[][] map) {
		int cnt =0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	
	
	static class CCTV{
		int x;
		int y;
		int num;
		public CCTV(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
		
	}
	

}
