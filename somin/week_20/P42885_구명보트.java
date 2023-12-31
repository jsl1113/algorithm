package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class P42885_����Ʈ {

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
			
			//���� ������ ����� ���ſ� ����� limit���� �۰ų� ������ �Ѵ� out
			if(p[s]+p[e] <= lmt) {
				s++;
				e--;
			}else { //limit���� ũ�� ���ſ�ָ� out
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
