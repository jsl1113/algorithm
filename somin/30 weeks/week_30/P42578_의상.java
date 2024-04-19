package programmers;

import java.util.HashMap;
import java.util.Map;

public class P42578_ÀÇ»ó {
	public int solution(String[][] clothes) {
        int answer = 1;
        
        int len = clothes.length;
        System.out.println(len);
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<len;i++){
            String name = clothes[i][0];
            String kind = clothes[i][1];
            if(map.containsKey(kind)){
                map.put(kind, map.get(kind)+1);
            }else{
                map.put(kind, 1);
            }
            
        }
        int all = 0;
        int plus = 0;
        System.out.println(map.size());
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(String.format("Key (name) is: %s, Value (age) is : %s", pair.getKey(), pair.getValue()));
            
            int val = pair.getValue();
            answer *= (val+1);
        }
        
        System.out.println(all);
        System.out.println(plus);
        
        
        
        return answer-1;
    }
}
