import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17952_과제는끝나지않아 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Stack<Work> stack  = new Stack<B17952_과제는끝나지않아.Work>();
		
		int ans =0;
		for(int i=0;i<n;i++) {
			String[] input = br.readLine().split(" ");
			int num = Integer.parseInt(input[0]);
			
			if (num == 1) {
                int score = Integer.parseInt(input[1]);
                int time = Integer.parseInt(input[2]);
                stack.push(new Work(score, time));
            }
			
			if (!stack.isEmpty()) {
				Work current = stack.peek();
                current.time--; // 1분 수행

                if (current.time == 0) {
                    ans += current.score;
                    stack.pop(); // 과제 완료
                }
            }
		}
		System.out.println(ans);

	}
	
	static class Work{
		int score;
		int time;
		Work(int score, int time){
			this.score = score;
			this.time = time;
		}
	}

}
