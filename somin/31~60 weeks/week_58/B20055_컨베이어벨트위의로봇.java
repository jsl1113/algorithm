import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;
/*
 * ������ �� ��;
 * �κ��� �̵��� �� (a���->b���) a����� �������� �ٴ� �� �˰� ��� Ʋ�ȴ�.
 * �־��� ����. 
 */
public class B20055_�����̾Ʈ���Ƿκ� {

	static int n,k;
	static int[] arr;
	static LinkedList<Integer> lst = new LinkedList<>();
	static boolean[] rbIdx;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		 n = Integer.parseInt(st.nextToken());
		 k = Integer.parseInt(st.nextToken());
		 
		 arr = new int[2*n];
		 rbIdx = new boolean[n];
		 
		 st = new StringTokenizer(br.readLine());
		 for(int i=0;i<2*n;i++) {
			 arr[i] = Integer.parseInt(st.nextToken());
			 lst.add(arr[i]);
		 }
		 
		 int cnt = 0;
		 while(true) {
			 int countZ = 0;
			 cnt++;
			 //1
			 int now = lst.removeLast();
			 lst.addFirst(now);
			 //�κ��̵�
			 for(int i=n-1;i>=1;i--) {
				 rbIdx[i] = rbIdx[i-1];
			 }
			 //�κ��� n�̸� ������
			 rbIdx[n-1] = false;
			 rbIdx[0] = false;
			 
			 //2
			 //�κ��̵�
			 for(int i=n-2;i>=0;i--) {
				 if(rbIdx[i] && lst.get(i+1)!=0 && rbIdx[i+1]==false) { //�κ��� ������
					 rbIdx[i] = false;
					 int tmp = lst.get(i);
					 lst.set(i+1, lst.get(i+1)-1);
					 rbIdx[i+1] = true;
				 }
			 }
			 //�κ��� n�̸� ������
			 rbIdx[n-1] = false;
			 
			 //3
			 if(lst.get(0)>0) {
				 rbIdx[0] = true;
				 lst.set(0, lst.get(0)-1);
			 }
			 //4
			 for(int i=0;i<lst.size();i++){
	                if(lst.get(i)==0){
	                	countZ++;
	                }
	            }
			 
			 if(countZ>=k) {
				 break;
			 }
		 }
		 System.out.println(cnt);
		 
	}

}
