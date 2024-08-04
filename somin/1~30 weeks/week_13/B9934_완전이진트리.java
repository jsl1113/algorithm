package BOJ.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B9934_완전이진트리 {

   static int k;
   static int[] arr;
   static ArrayList<Integer> [] list;
   
   static StringBuilder sb = new StringBuilder();
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      k = Integer.parseInt(br.readLine());
      
      list = new ArrayList[k];
      
      for(int i=0; i<k;i++) {
    	  list[i] = new ArrayList<Integer>();
      }
      
      //노드 개수 2 (k-1)제곱
      int len = (int) (Math.pow(2, k)-1);
      arr = new int[len];
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      for(int i=0;i<len;i++) {
    	  arr[i] = Integer.parseInt(st.nextToken());
      }

      tree(0,len-1,0);
      
      for(ArrayList<Integer> l : list) {
    	  for(int m : l) {
    		  System.out.print(m+" ");
    	  }
    	  System.out.println();
      }
   }
   public static void tree(int s,int e, int depth) {
	   if(depth == k) {
		   return;
	   }
	   int mid = (s+e)/2;
	   list[depth].add(arr[mid]);
	   
	   tree(s, mid-1, depth+1);
	   tree(mid+1, e, depth+1);
	   
   }

}