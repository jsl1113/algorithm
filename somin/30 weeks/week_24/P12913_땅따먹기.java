package programmers;

import java.util.Arrays;

public class P12913_�����Ա� {

	public static void main(String[] args) {
		
		
		System.out.println(solution(new int [][] 
				{{1,2,3,5},{5,6,7,8},{4,3,2,1}} ));
	}
	
	static int solution(int[][] land) {
        int answer = 0;

        int len = land.length;
        int [][] dp = new int [len][4];

        for(int i=0;i<len;i++) {
        	for(int j=0;j<4;j++) {
        		
        		dp[i][j] = land[i][j];
        		
        		if(i==0) continue;
        		
        		// 0,1,2,3 �߿� ���� ���� �ִ��� ���� ã�ƶ�
        		
        		int pre = max(j, dp, i-1);
        		dp[i][j] += pre;
        		
        	}
        }
        for(int i=0;i<4;i++) {
        	answer = (answer<dp[len-1][i]) ? dp[len-1][i]:answer;
        }
        
        return answer;
    }
	
	
	static int max(int now, int[][] dp, int num) {
		
		int max = 0;
		for(int i=0;i<4;i++) {
			if(i==now) continue;
			if(max<dp[num][i]) max = dp[num][i];
		}
		
		return max;
	}
	
}
