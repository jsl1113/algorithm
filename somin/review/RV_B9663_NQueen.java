package review.w14Over;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RV_NQueen {

	static int n,ans=0;
	
	static int[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		v = new int[n];
		//���ึ�� �ϳ��� ������ �ȴ�
		//�밢������ ��ġ�� �ʱ�
		
		solve(0);
		System.out.println(ans);
	}
	
	static void solve(int cnt) {
		
		if(cnt==n) {
			ans++;
			return;
		}
		
		for(int i=0;i<n;i++) {
			v[cnt] = i;
			//�밢��üũ
			if(isLine(cnt)) {
				solve(cnt+1);
			}
		}
		
		//����� ������ ��� �밢��üũ�� �ȵȾֵ��� �׳� return
		return;
	}
	
	/*
	 * ���� ���� �ִ���, �밢���� �ִ��� üũ�ϰ�
	 * true : ���� ���ݹ����� ����
	 */
	static boolean isLine(int now) {
		
		for(int i=0;i<now;i++) {
			
			if(v[i] == v[now]) {
				return false;
			}
			//�밢���� �ִٸ� ��, �ﰢ���� �̵�̸�
			if(now-i == Math.abs(v[now]-v[i])) {
				return false;
			}
			
		}
		
		
		return true;
	}

}
