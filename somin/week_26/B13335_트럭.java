import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B13335_Ʈ�� {

	// n = Ʈ�� ����
	// w = �ٸ� ���� (Ʈ���� �ٸ����� �ִ� w�� �� �� �ִ�)
	// L = Ʈ�� ���� �ִ� ����
	// arr = ������� Ʈ���� ����
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		
		int arr[] = new int[n];
		Queue<Integer> que = new LinkedList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			que.add(arr[i]);
		}
		
		//�ٸ� ���� �ִ� ����
		Queue<Integer> bridge = new LinkedList<Integer>();
		for(int i=0;i<w;i++) {
			bridge.add(0);
		}
		
		int time =0;
		int weight = 0;
		
		while(!bridge.isEmpty()) {
			
			int now = bridge.poll();
			weight -= now;
			
			time++;
			
			//ť���� 
			if(!que.isEmpty()) {
				// ���� ���� üũ
				int peek = que.peek();
				if(peek + weight <=L) {
					bridge.add(que.poll());
					weight+=peek;
				}else {//���԰� �ʰ���
					bridge.add(0);
				}
			}
			
			
		}
		
		
		System.out.println(time);
		
		
		 
	}

}
