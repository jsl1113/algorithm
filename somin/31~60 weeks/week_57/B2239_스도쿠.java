import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * �ظ� �κ� : 
 * 1. arr�� 0�� ��찡 ���ٸ� 10,10�� ����� 10�� �� system.exit(0)�� �ϴ� ���̵��
 * 2. �ߺ����� �ƴ��� üũ�ϰ� arr[i][j]= num �Ʒ��ٿ� ��ͷ� ���� �κ�.
 * 
 * ������ : �����ð��� ������ ��Ͷ�� ������ ���ϰ� �ߺ�üũ�� ������ �ߴ�.�ٺ�.
 */
public class B2239_������ {

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
		
		//���� ���� üũ
		for(int i=0;i<9;i++) {
			if(arr[i][y] == num || arr[x][i] ==num) {
				return false;
			}
		}
		
		//�׸� üũ
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
