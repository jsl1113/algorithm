import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * ó�� Ǯ�� : �� ���̸� ä��� �������� ���� �ʰ�
 * ���� ������ ����Ž������ Ǫ�� ������� �ߴ�.. 
 * ��ü 0�� ��� input �� ��ü 0�� ��µ� .. 
 * 
 * �� : 
 * 0�� �ֵ��߿� , 
 * 1~9���� �־ ���� ��ͷ� ���� �����ϱ�
 * col ���� ���� ��Ű�鼭 ����
 * 
 */
public class B2580_������ {

   static int [][] map = new int [9][9];
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;// = new StringTokenizer(br.readLine());

      for(int i=0;i<9;i++) {
         st = new StringTokenizer(br.readLine());
         for(int j=0;j<9;j++) {
            map[i][j] = Integer.parseInt(st.nextToken());
         }
      }
      
      dfs(0, 0);
           
      
   }
   
   static void dfs(int r, int c) {
	   
	   if(c==9) {
		   dfs(r+1,0);
		   return;
	   }
	   if(r==9) {
		   for (int[] aa : map) {
			for (int a : aa) {
				System.out.print(a + " ");
			}
			System.out.println();
		   }
		   System.exit(0);
	   }
	   
	   
	   if(map[r][c]==0) {
		   for(int i=1;i<=9;i++) {
			   if(check(r, c, i)) {
				   map[r][c] = i;
				   dfs(r,c+1);
			   }
				   
		   }
		   //�� ���Ҵµ��� ���� ��ġ�� 
		   map[r][c] = 0;
		   return;
	   }
	   
	   //���� c�� ������Ŵ
	   dfs(r,c+1);
	   
	   
	   
   }
   
   static boolean check(int row, int col, int num) {
	   
	   //���� 
	   for(int i=0;i<9;i++) {
		   if(map[row][i]== num) {
			   return false;
		   }
	   }
	   
	   //����
	   for(int i=0;i<9;i++) {
		   if(map[i][col]== num) {
			   return false;
		   }
	   }
	   
	   
	   //�׸�
	   
	   int rr = (row/3)*3;
	   int cc = (col/3)*3;
	   
	   
	   
	   for(int i=rr;i<rr+3;i++) {
		   for(int j=cc;j<cc+3;j++) {
			   if(map[i][j]==num) {
				   return false;
			   }
		   }
	   }
	   return true;
   }
   
   
   
   
}