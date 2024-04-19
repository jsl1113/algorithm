package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9095_123¥ı«œ±‚ {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());		
		int [] arr= new int[11];
		
		arr[1]=1; arr[2]=2;arr[3]=4;
		
		for(int i=4;i<11;i++) {
			arr[i] = arr[i-1]+arr[i-2]+arr[i-3];
//			System.out.println(arr[i]+"  "+ i);
		}
		
		for(int i=0;i<T;i++) {
			System.out.println(arr[Integer.parseInt(bf.readLine())]);
		}

	}
}
