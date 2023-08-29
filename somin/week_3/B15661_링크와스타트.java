package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * N�� �߿� ��� ���� ����� ���� �����ؼ� ���� �ɷ�ġ ������ �ּҰ� ���ϱ�
 * �� Ǭ ���� : �κ������� ���ϴ� ����� ������. ������ ������ ���� �򰥸�
 * �κ� ������ ���ϰ� ������ �� ��Ĵ�� Ǯ���� / ��Ʈ����ŷ�� �𸣰ڴ�.
 */
public class B15661_��ũ�ͽ�ŸƮ {

	static int n;
	static int [][] s;
	static boolean []isTeam;
	static int distMin = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = new int[n][n];
		isTeam=new boolean[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<n;j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0);
		
		System.out.println(distMin);

	}

	// �κ������� ���ϴ� �Լ� 
	public static void dfs(int cnt ) {
		if(cnt==n) {
			int tcheck=0;
			for (int i = 0; i < n; i++) {
	            if (isTeam[i] == true) {
	            	tcheck ++;
	            }
	        }
			if(tcheck>1 && tcheck<n-1) {
				dist();
			}
	        return;
		}
		
		isTeam[cnt] = true;
		dfs(cnt+1);
		
		isTeam[cnt] = false;
		dfs(cnt+1);
	}
	/*
	 *    �� ���� ������ �ּڰ� ���ϴ� �Լ�
	 * 1. ��� �κ����� ��츦 �������� 
	 * (dfs�Լ����� 1 : n-1 �� �������� �κ��Լ��� ������) - > n = 4 �϶� 1/2 3 4 �� ��� ���̰� �ּҰ��� �� ���⶧��
	 * 2. true �� ��� start ��̸���Ʈ�� �ְ� ������ link��
	 * 3. �� ���� �ɷ�ġ ���ϱ� (����for��)
	 * 4. �ɷ�ġ ���̸� �����ϰ� �ּڰ��� distMin�� ����
	 */
	public static void dist() {
		ArrayList<Integer> start = new ArrayList<Integer>();
		ArrayList<Integer> link = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) {
            if (isTeam[i] == true) {
            	start.add(i+1);
            }else {
            	link.add(i+1);
            }
        }
		
		int sumS =0; 
		int sumL =0; 

		for(int i: start) { 
			for(int j: start) { 
				sumS+=s[i-1][j-1];
			}
		}
		for(int i: link) {
			for(int j: link) { 
				sumL+=s[i-1][j-1];
			}
		}
		
		distMin = Math.min(distMin, Math.abs(sumS-sumL));

	}

}
