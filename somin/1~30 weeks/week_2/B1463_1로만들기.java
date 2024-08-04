package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1463_1로만들기 {
	
	static int[] a;
	
	public static int f(int num) {
		
		if(num ==1 ) return 0;
		if(num ==2 ) return 1;
		if(num ==3 ) return 1;
		
		if(a[num]!=0) return a[num];
		
		if(num%2==0 && num%3==0) {
			a[num] = Math.min(Math.min(f(num/3), f(num/2)), f(num-1))+1;
		}
		else if(num%3==0){
			a[num] = Math.min(f(num/3), f(num-1))+1;
		}
		else if(num%2==0) {
			a[num] = Math.min(f(num/2), f(num-1))+1;
	
		}
		else
			a[num]= f(num-1)+1;
	
		return a[num];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		
		a = new int [N+1];
		
	    a[1] = 0; 

		System.out.println(f(N));
		
	}

}
