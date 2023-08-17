package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B4949_±ÕÇüÀâÈù¼¼»ó {
	

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String[] arrList;
		
		while(true) {
			arrList = (bf.readLine().split(""));
			if(arrList[0].equals(".")) {
				break;
			}
			
			int a=0;   //( )
			int b=0;   //[]
			Stack<String> stack = new Stack<String>();

			for(String s: arrList) {
				if(s.equals("(")) {
					a++;
					stack.push("(");
				}
				if(s.equals("[")) {
					b++;
					stack.push("[");
				}
				if(s.equals(")")) {
					a--;
					if(stack.size()>0) {
						if(!stack.peek().equals("(")) {
							System.out.println("no");
							break;
						}else if(stack.peek().equals("(")) {
							stack.pop();
						}
					}
					
				}
				if(s.equals("]")) {
					b--;
					if(stack.size()>0) {
						if(!stack.peek().equals("[")) {
							System.out.println("no");
							break;
						}else if(stack.peek().equals("[")) {
							stack.pop();					
						}
					}
				}

				if(a<0 || b <0) {
					System.out.println("no");
					break;
				}
				
				if(s.equals(".")) {
					if(stack.isEmpty()) {
						System.out.println("yes");
					}else
						System.out.println("no");
					break;
				}
			
			}
			
		}
	}

}
