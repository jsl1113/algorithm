package BOJ.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1439_뒤집기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String [] list = s.split("");
		
//		System.out.println(Arrays.toString(list));
		
		int oneCnt = 0; 
		int zCnt =0; 
		
		int pri = Integer.parseInt(list[0]);
		if(pri==1) oneCnt++;
		else
			zCnt++;
//		System.out.println(oneCnt+" // "+zCnt);
		
		for(int i=1;i<list.length;i++) {
			int now = Integer.parseInt(list[i]);
			int p = Integer.parseInt(list[i-1]);

			//그전이랑 같으면 pass
			if(now == p) continue;
			
			//다르면 현재 0인지 1인지
			if(now==1) {
				oneCnt++;
			}else {
				zCnt++;
			}
		}
		
		
//		System.out.println(oneCnt+" // "+zCnt);
		System.out.println(Math.min(oneCnt,zCnt));
		
	}

}
