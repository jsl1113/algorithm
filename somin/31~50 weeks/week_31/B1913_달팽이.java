import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1913_달팽이 {
   
   static int[] dx = {1,0,-1,0};
   static int[] dy = {0,1,0,-1};

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      
      int where = Integer.parseInt(br.readLine());
      
      int r = 0;
      int c = 0;
      
      int map[][] = new int[n][n];
      boolean visit[][] = new boolean[n][n];
      
      int now = n*n;
      
      int flag = 0; // 0 : 아래 / 1: 오른쪽 / 2: 위 / 3: 왼쪽
      
      map[r][c] = now;
      visit[r][c] = true;
            
      while(now!=1) {

         now--;
         
         if(flag==4) {
        	 flag=0;
         }
         
         int nx = r + dx[flag];
         int ny = c + dy[flag];
         
         if(nx<0 || nx >=n || ny <0 || ny>=n || visit[nx][ny]) {
            flag++;
            now++;
         }else{
            map[nx][ny] = now;
            r = nx;
            c = ny;
            visit[nx][ny] = true;
            
//            if(now==where) {  이 것 때문에 처음에 틀림 ;
//            	ansr = r+1;
//            	ansc = c+1;
//            }
         }
         
         
      }
      
      StringBuilder sb = new StringBuilder();
      
      for(int []m : map) {
         for(int mm: m) {
            sb.append(mm+" ");
         }
         sb.append("\n");
      }

      for(int i=0;i<n;i++) {
    	  for(int j=0;j<n;j++) {
    		  if(map[i][j]==where) {
    			  sb.append((i+1)+" "+(j+1));
    		  }
    	  }
      }
      
      System.out.println(sb);
   }
   
}