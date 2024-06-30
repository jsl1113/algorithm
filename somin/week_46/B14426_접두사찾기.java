import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
/*
 * �̺�Ž�� ����
 *  - compareTo �� ���ڿ� �񱳸� �����Ͽ� �� ���ڿ��� ������ ������ ������.
 *  �����̸� ù��°�� �ι�° ���ڿ����� �۴�.
 *  ����̸� ù��°�� �� ũ��.
 *  0�̸� �ΰ��� ����.
 */
public class B14426_���λ�ã�� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<String> lst = new ArrayList<String>();
		
		for(int i=0;i<n;i++) {
			lst.add(br.readLine());
		}


		Collections.sort(lst);

		int ans = 0;
		for(int i=0;i<m;i++) {
			String ss = br.readLine();
			int left = 0; 
			int right = n-1;
			boolean flag = false;
			while(left<=right) {
				int mid = (left+right) / 2;
				
				if(ss.compareTo(lst.get(mid))>0) { //ss�� �� ŭ = ���������� �ڴ�.
					left = mid+1;
				}else if(ss.compareTo(lst.get(mid))<0) {
					right = mid-1;
				}else { //0�̸� ������
					flag = true;
					break;
				}
				
				if(lst.get(mid).startsWith(ss)) {
					flag = true;
					break;
				}
				
			}
			if(flag) {
				ans++;
			}
		}
		System.out.println(ans);
		
	}

}
