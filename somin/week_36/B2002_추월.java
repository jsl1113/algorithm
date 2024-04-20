import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class B2002_�߿� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		
		Map<String, Integer> in = new LinkedHashMap<String, Integer>();
		Map<String, Integer> out = new LinkedHashMap<String, Integer>();
		
		//�� ��
		int cnt = 0;
		for(int i=0;i<n;i++) {
			in.put(br.readLine(), cnt++);			
		}
		
		//���� ��
		int ans = 0;
		boolean flag = false;
		
		for(int i=0;i<n;i++) {
			String num = br.readLine();
			int inNum = in.get(num);
			out.put(num, inNum);			
			
		}
		
		//���� �� 0���� �����ϴ� ���������� ������ ����
		
//		System.out.println(in);
//		System.out.println(out);
		
		int order = 0;
		int now=0;
		
		boolean [] visit = new boolean[n];
		for(Integer key : out.values()) {
			//order�ϰ� ������ 
			if(key==now) {
				ans++;
				now++;
				while(now<n) {
					if(visit[now]) {
						now++;
					}else {
						break;
					}
				}
			}
			
			visit[key] = true;
			order++;
		}
		
		System.out.println(n-ans);
	}

	
}
