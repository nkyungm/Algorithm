import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        Deque<Character> stack = new ArrayDeque<>();
        int answer = 0;
        int temp = 1;

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                stack.addLast(c);
                temp *=2;
                continue;
            }
            if(c=='[') {
                stack.addLast(c);
                temp *= 3;
                continue;
            }
            if(stack.isEmpty()){
                System.out.println(0);
                return;
            }
            if(c==')'){
                if(stack.pollLast() != '('){
                    System.out.println(0);
                    return;
                }
                if(s.charAt(i-1) == '(') answer+=temp;
                temp/=2;
                continue;
            }
            if(c==']'){
                if(stack.pollLast() != '['){
                    System.out.println(0);
                    return;
                }
                if(s.charAt(i-1) == '[') answer+=temp;
                temp/=3;
            }
        }
        if(!stack.isEmpty()) {
            System.out.println(0);
            return;
        }

        System.out.println(answer);
    }
}

