import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1459_�ȱ� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		
		long x=Long.parseLong(st.nextToken());
        long y=Long.parseLong(st.nextToken());
        long w=Long.parseLong(st.nextToken());  
        long s=Long.parseLong(st.nextToken());  
        
		//�Ѻ�Ͼ� 
		long sum = (x+y);
		long one = sum*w;
				
		//�밢�� s
		long minNum = Math.min(x, y);
		long two = minNum*s + ((Math.max(x, y))-minNum)*w;
		
		long three;
		if((x+y)%2==0) { //¦���϶��� ���� (�밢�� �켱)
			long tmp3 = Math.max(x, y);
			three = (tmp3)*s;
		}else {
			three = (Math.max(x, y)-1)*s + w;
		}
		
		System.out.println(Math.min(one, Math.min(two, three)));
	}

}
