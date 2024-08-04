package BOJ.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
// 바보 스펠링 valid 틀림
public class B1331_나이트투어 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String chess = br.readLine();
		
		int [] pre = new int[2];
		int [] pp = new int[2];
		
		pre[0] = chess.charAt(0);
		pre[1] = chess.charAt(1);
		pp[0] = chess.charAt(0);
		pp[1] = chess.charAt(1);
		
		ArrayList<String> visit = new ArrayList<String>();
		visit.add(chess);
		
		for(int i=0;i<35;i++) {
			
			String no = br.readLine();
			
			int [] nn = new int[2];

			nn[0] = no.charAt(0);
			nn[1] = no.charAt(1);
			
			if(visit.contains(no)) {
			
				System.out.println("Invalid");
				return;				
			}
			
			int r = Math.abs(nn[0] - pre[0]) + Math.abs(nn[1]-pre[1]);
			
			if( Math.abs(nn[0] - pre[0]) ==1 && Math.abs(nn[1]-pre[1])==2) {
				
			}else if(Math.abs(nn[0] - pre[0]) ==2 && Math.abs(nn[1]-pre[1])==1) {
				
			}else {
	
				System.out.println("Invalid");
				return;		
			}
		
			visit.add(no);
			pre = nn;
			
			
		}
		
		int r = Math.abs(pp[0]-pre[0])+Math.abs(pp[1]-pre[1]);
		if( Math.abs(pp[0] - pre[0]) ==1 && Math.abs(pp[1]-pre[1])==2) {
			
		}else if(Math.abs(pp[0] - pre[0]) ==2 && Math.abs(pp[1]-pre[1])==1) {
			
		}else {

			System.out.println("Invalid");
			return;		
		}
		System.out.println("Valid");
	

	}


	
}
