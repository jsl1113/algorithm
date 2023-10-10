package BOJ.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;
/*
 * µ¶. deque
 * addFirst()                  /    addLast()  add()
 * removeFirst() pollFirst()   /  removeLast() pollLast()
 *  peekFirst()                /  peekLast()
 */
public class B2346_«≥º±≈Õ∂ﬂ∏Æ±‚ {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		boolean status;
		Deque<Point> dq = new ArrayDeque<>();
		int cnt=0;
		
		for(int i=0;i<n;i++) {
			int a = Integer.parseInt(st.nextToken());
			dq.add(new Point(a, i+1));

		}

		StringBuilder sb2 = new StringBuilder();  //≈Õ¡¯ «≥º±¿« ¿Œµ¶Ω∫
		
		
		Point p =dq.removeFirst();
		int num = p.x; 
		sb2.append(1+" ");

		status = (num<0) ? false:true;
		num = Math.abs(num);
		
		while(!dq.isEmpty()) {
			//æÁºˆ¿œ∞ÊøÏ
			if(status) {
				cnt++;
				if(cnt == num) {
					Point pp = dq.removeFirst();
					num = pp.x;

					sb2.append(pp.idx+" ");
					status = (num<0) ? false:true;
					num = Math.abs(num);
					cnt=0;
				}
				else {
					Point a = dq.removeFirst();
					dq.add(a);
				}
				
			}
			else {// ¿Ωºˆ ¿œ ∞ÊøÏ
				cnt++;
				if(cnt == num) {
					Point pp = dq.removeLast();
					num = pp.x;
					
					sb2.append(pp.idx+" ");
					status = (num<0) ? false:true;
					num = Math.abs(num);
					cnt=0;
				}
				else {
					Point b = dq.removeLast();
					dq.addFirst(b);
				}
			}
			
			
			
		}
		

		System.out.println(sb2);

	}

}

class Point { // ∞™ , «≥º±¿« ¿Œµ¶Ω∫
	int x,idx;
	Point(int x, int idx){
		this.x=x;
		this.idx=idx;
	}
}