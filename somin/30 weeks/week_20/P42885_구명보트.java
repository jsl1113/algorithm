package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class P42885_구명보트 {

	static int len, lmt;
	static int solution(int[] people, int limit) {
        int answer = -1;
        
        Arrays.sort(people);
        len = people.length;
        lmt = limit;

        System.out.println(Arrays.toString(people));

        
        return pointer(people);
    }
	
	
	static int pointer(int[] p) {
		
		int s = 0;
		int e = len-1;
		int cnt = 0;
		while(s<=e) {
			
			//무게 가벼운 사람과 무거운 사람이 limit보다 작거나 같으면 둘다 out
			if(p[s]+p[e] <= lmt) {
				s++;
				e--;
			}else { //limit보다 크면 무거운애만 out
				e--;
			}
			cnt++;
		}
		return cnt;
		
	}


	
	
	
    public static void main(String[] args) {
        System.out.println(solution( new int[]{70, 50, 30, 50}, 100));
    }
}
