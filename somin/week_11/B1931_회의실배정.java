package BOJ.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1931_회의실배정 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int [][] time = new int[n][2];
		for(int i=0;i<n;i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(time, (a,b)-> {
			return a[0]-b[0];
		});
		Arrays.sort(time, (a,b)-> {
			return a[1]-b[1];
		});
		

		int cnt=1;
		int fin= time[0][1];
		for(int i=1;i<n;i++) {
			if(time[i][0]>=fin) {

				fin = time[i][1];
				cnt+=1;
			
			}
		}
		System.out.println(cnt);
	}

}
