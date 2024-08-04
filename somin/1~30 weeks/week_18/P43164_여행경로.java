package programmers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class P43164_여행경로 {

	static int tcnt;
	static boolean [] visited;
	static ArrayList<String> ans = new ArrayList<>();
	static ArrayList<String> anslst = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {

//		String [][] tickets ={{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
//		String [][] tickets ={{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String [][] tickets ={{"ICN", "JFK"}, {"ICN", "AAD"}, {"JFK", "ICN"}};
	
		Arrays.sort(tickets , new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				if(o1[0] == o2[0]) {
					
					return o1[1].toString().charAt(0)-o2[1].toString().charAt(0);
				}
				else
					return o1[0].toString().charAt(0)-o2[0].toString().charAt(0);
			}
			
		} );
		
		tcnt = tickets.length;
		
		visited = new boolean[tcnt];
		
		ans.add("ICN");

		dfs("ICN", 0, tickets);
		
		Collections.sort(anslst);
		
		System.out.println(anslst.get(0));
		
	}
	
	static void dfs(String departure, int cnt, String[][] tickets) {
		if(cnt == tcnt) {
			System.out.println(ans);
			String list = "";
			for(int j=0;j<ans.size();j++) {
				list +=ans.get(j);
				list += " ";
			}
			anslst.add(list);
			return;
		}

		for(int i=0;i<tcnt;i++) {
			if(tickets[i][0].equals(departure)) {
				if(!visited[i]) {
					visited[i] = true;
					ans.add(tickets[i][1]);
					dfs(tickets[i][1],cnt+1,tickets);
					visited[i] = false;
					ans.remove(ans.size()-1);
				}
			}
		}
		

	}

}
