import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class B6443_애너그램 {

	static int n;
    static int[] check;
    static Stack<Character> stack =new Stack<>();
    
    static Map<String, Integer> map = new HashMap<>();
	static ArrayList<String> lst;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
 
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<n; i++){
            char[] chars = br.readLine().toCharArray();
            int length = chars.length;
            check = new int[26];
            
            for(char now: chars){
                check[now-'a']++;
            }
            
            lst = new ArrayList<String>();
			map = new HashMap<String, Integer>();
			
            dfs(length);
            
            Collections.sort(lst);

			for(String ss : lst) {
				sb.append(ss+"\n");
			}
        }
        System.out.println(sb.toString());
    }
 
    private static void dfs(int limit) {
        if(limit== stack.size()){
            StringBuilder sb = new StringBuilder();
            for(char now: stack){
                sb.append(now);
            }
            if(!map.containsKey(sb.toString())) {
            	lst.add(sb.toString());
				map.put(sb.toString(), 1);
			}
        }
 
        for(int i=0; i<26; i++){
            if(check[i]>0){
                check[i]--;
                stack.push((char)(i+'a'));
                dfs(limit);
                stack.pop();
                check[i]++;
            }
        }
    }
}