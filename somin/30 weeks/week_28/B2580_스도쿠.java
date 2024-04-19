import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 처음 풀이 : 빈 종이를 채우는 느낌으로 하지 않고
 * 정말 스도쿠를 완전탐색으로 푸는 방법으로 했다.. 
 * 전체 0인 행렬 input 시 전체 0이 출력됨 .. 
 * 
 * 답 : 
 * 0인 애들중에 , 
 * 1~9까지 넣어서 들어가면 재귀로 다음 진행하기
 * col 먼저 증가 시키면서 진행
 * 
 */
public class B2580_스도쿠 {

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
		   //다 돌았는데도 수가 겹치면 
		   map[r][c] = 0;
		   return;
	   }
	   
	   //먼저 c를 증가시킴
	   dfs(r,c+1);
	   
	   
	   
   }
   
   static boolean check(int row, int col, int num) {
	   
	   //가로 
	   for(int i=0;i<9;i++) {
		   if(map[row][i]== num) {
			   return false;
		   }
	   }
	   
	   //세로
	   for(int i=0;i<9;i++) {
		   if(map[i][col]== num) {
			   return false;
		   }
	   }
	   
	   
	   //네모
	   
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