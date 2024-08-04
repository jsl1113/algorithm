import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B1092_น่ {

	static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> boxes = new ArrayList<Integer>();
		ArrayList<Integer> crane = new ArrayList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			crane.add( Integer.parseInt(st.nextToken()));
		}

		m = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {
			boxes.add( Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(boxes);
		Collections.sort(crane);
		Collections.reverse(crane);
		Collections.reverse(boxes);
		
//		System.out.println(crane);
//		System.out.println(boxes);

		if(crane.get(0) < boxes.get(0)) {
			System.out.println(-1);
			return;
		}
		
		int cnt = 0;
		while(!boxes.isEmpty()) {
			
			for(int i=0;i<crane.size();i++) {
				int c = crane.get(i);
				
				for(int j=0;j<boxes.size();j++) {
					if(c >= boxes.get(j)) {
						boxes.remove(j);
						break;
					}
				}
			}
			cnt++;
			
		}
		System.out.println(cnt);
				
		
	}
	
}
