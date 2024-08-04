import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9663_NQueen {

	static int n;
	static int[] visit;
	static int ans=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		visit = new int[n];

		//�ϳ��� �࿡�� �ϳ��� ����.
		// ���� ���� ���� �ִ���
		//�밢���� ���� �ִ���
		bt(0);
		
		System.out.println(ans);
		
	}
	
	static void bt(int cnt) {
		
		//n���� ���� ä������ ����+1
		if(cnt == n) {
			ans++;
			return;
		}
		
		for(int i=0;i<n;i++) {
			visit[cnt] = i;
			if(isQueen(cnt)) {
				bt(cnt+1);
			}
		}
		
		return; 
	}
	
	static boolean isQueen(int cnt) {
		
		for(int i=0;i<cnt;i++) {
			//���� ���� ������ false
			if(visit[i] == visit[cnt]) {
				return false;
			}
			
			//�밢���� ������ false
			if(Math.abs(cnt-i)== Math.abs(visit[cnt] - visit[i]) ) {
				return false;
			}
			
		}
		
		return true;
	}

}
