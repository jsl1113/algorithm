import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B16165_걸그룹마스터준석이 {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); 
        
        Map<String, ArrayList<String>> map = new HashMap<>(); 

        
        for (int i=0;i<n;i++) {
            String group = br.readLine();
            int num = Integer.parseInt(br.readLine()); 
            ArrayList<String> list = new ArrayList<>(); 
            for (int j=0;j<num;j++) {
                list.add(br.readLine()); 
            }
            map.put(group, list); 
        }
        
        StringBuilder sb = new StringBuilder(); 
        
        for (int i=0;i<m;i++) {
            String name = br.readLine(); 
            int member = Integer.parseInt(br.readLine()); 
            
            if(member == 1) { 
                for(String group : map.keySet()) { 
                    if(map.get(group).contains(name)) { 
                        sb.append(group + "\n"); 
                        break;
                    }
                }
            }else{ 
            	ArrayList<String> list = map.get(name); 
                Collections.sort(list); 
                for(String memberName : list) {
                    sb.append(memberName + "\n"); 
                }
            }
        }

        System.out.println(sb); 

    }

}