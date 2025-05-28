import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B9935_문자열폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String del = br.readLine();

        Stack<Character> stack = new Stack<>();

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            stack.add(c);

            if(stack.size()>=del.length()){
                boolean flag = true;

                for(int j=0;j<del.length();j++){
                    if(stack.get(stack.size()-del.length()+j)!=del.charAt(j)){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    for(int j=0;j<del.length();j++){
                        stack.pop();
                    }
                }
            }

        }

        if(stack.isEmpty()){
            System.out.println("FRULA");
        }else{
            for(char c : stack){
                System.out.print(c);
            }
        }


    }
}
