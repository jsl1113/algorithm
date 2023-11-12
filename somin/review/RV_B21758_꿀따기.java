package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RV_B21758_曹蝶扁 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int [] honey = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sum=0;
		
		for(int i=0;i<n;i++) {
			honey[i] = Integer.parseInt(st.nextToken());
			sum+=honey[i];
		}
		
		
		long result=0;
		//国烹捞 坷弗率 场 /国=0,x
		long sumB = sum - honey[0];
		long ans = sumB;
		
		for(int i=1;i<n-1;i++) {
			long f = sumB - honey[i];
			ans -= honey[i];
			
			result = Math.max(result, f+ans);			
		}
		
		
		//国烹捞 哭率 场 / 国=n-1,x
		sumB = sum - honey[n-1];
		ans = sumB;
		
		for(int i=n-2;i>0;i--) {
			long s = sumB - honey[i];
			ans -=honey[i];
			
			result = Math.max(result, s+ans);
		}
		
		
		//国捞 剧率 场 0,n-1 / 国烹 x
		sumB = sum - honey[0] - honey[n-1];
		ans = sumB;
		
		for(int i=1;i<n-1;i++) {
			long f = sumB +honey[i];
			result = Math.max(result, f);
		}
		
		System.out.println(result);
	}

}
