package BOJ;


import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2164_Ä«µå2 {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1;i<=n;i++) {
			q.add(i);
		}

		while(q.size()>1) {
			if(q.size()==1) break;
			q.poll();
			int num = q.peek();
			q.add(num);
			q.poll();

		}
		System.out.println(q.peek());

	}

}
