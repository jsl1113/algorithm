package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
//바보다 그냥 거꾸로 뒤집는 것만 생각나고 왜 갯수로 하는 걸 못하겠지..?
public class B11722_가장긴감소하는부분수열 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(bf.readLine());
		int [] arr = new int[a];
		ArrayList<Integer> reverse = new ArrayList<Integer>(); 

		int [] cnt = new int[a];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0;i<a;i++) {
			reverse.add(Integer.parseInt(st.nextToken()));
		}
		Collections.reverse(reverse);
		
		for(int i=0;i<a;i++) {
			arr[i] = reverse.get(i);
		}

//		System.out.println(Arrays.toString(arr));
		//10 30 10 20 20 10
		//10, 20, 20, 10, 30, 10
		
		cnt[0] = 1;
		for(int i=1;i<a;i++) {
			cnt[i] = 1;
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i]) {
					
					cnt[i] = Math.max(cnt[i], cnt[j]+1);
				}
			}
		}
		
//		System.out.println(Arrays.toString(cnt));
		
		int max = 1;
		int idx = 0;
		for(int i=0;i<a;i++) {
			if(max<cnt[i]) max = cnt[i];
		}
//		System.out.println(idx);
		System.out.println(max);
	}

}
