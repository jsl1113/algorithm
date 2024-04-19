package BOJ.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * 원래 하고 싶었던 거: 
 * String입력받으면 char로 쪼개서 그 알파벳을 가격에 맞게 저장하기..
 *  맵을 써보려햇는데 뭔가 계속 틀려서 시간이 너무 지체되어서 답.. 봐버렸다..
 *  
 *   답 : 
 *   그냥 간단하게 book클래스를 만들어서 쓰니까 진짜 간단하다. 
 *   클래스를 만들어 쓸 생각을 하자.ㅠ
 */

class Book{
    int price;
    String title;

    Book(int price, String title) {
        this.price = price;
        this.title = title;
    }
}

public class B16508_전공책 {
	
	static String word;
    static int N, min = Integer.MAX_VALUE;
    
    static ArrayList<Book> books = new ArrayList<>();
    static int[] cnt, selectCount = new int[26];
    
    
    
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        word = bf.readLine();
        cnt = new int[26];
        for(int i = 0; i < word.length(); i++) {
            cnt[word.charAt(i) - 'A']++;
        }
        N = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            books.add(new Book(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        dfs(0, 0);
        if(min == Integer.MAX_VALUE) min = -1;
        

        System.out.println(min);

    }

    static void dfs(int idx, int total){
        if(idx == N) {
            if(check()) {
                min = Math.min(min, total);
            }
            return;
        }
        for(int i = 0; i < books.get(idx).title.length(); i++) {
            selectCount[books.get(idx).title.charAt(i) - 'A']++;
        }
        dfs(idx + 1, total + books.get(idx).price);
        for(int i = 0; i < books.get(idx).title.length(); i++) {
            selectCount[books.get(idx).title.charAt(i) - 'A']--;
        }
        dfs(idx + 1, total);
    }

    static boolean check() {
        for(int i = 0; i < 26; i++) {
            if(cnt[i] > selectCount[i]) {
                return false;
            }
        }
        return true;
    }
}

