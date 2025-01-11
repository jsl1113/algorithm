import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1713_후보추천하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int m = Integer.parseInt(br.readLine());
		ArrayList<Student> list = new ArrayList<>();
		
		Student[] candidate = new Student[101];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(candidate[num]!=null) {
				candidate[num].rc++; //추천++
			}else {
				Collections.sort(list);
				
				if(list.size()>=n) {
					Student ss = list.remove(n-1);
					candidate[ss.num] = null; //초기화
				}
				
				candidate[num] = new Student(num, 1, i);
				list.add(candidate[num]);
			}
			
			
		}
		
		Collections.sort(list, (o1,o2)-> o1.num - o2.num);
		for(Student ss : list) {
			System.out.print(ss.num+" ");
		}
		
	}

	static class Student implements Comparable<Student>{
		int num;
		int rc;
		int time;
		public Student(int num, int rc, int time) {
			this.num = num;
			this.rc = rc;
			this.time = time;
		}
		
		
		@Override
		public int compareTo(Student o) {
			
			
			//추천 수가 같으면 시간순
			if(this.rc == o.rc) { 
				return o.time - this.time;
			}
			return o.rc - this.rc;
		}
		
	}
}
