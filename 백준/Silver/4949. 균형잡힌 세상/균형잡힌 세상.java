import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        while(true){
            String s = br.readLine();
            // 종료조건
            if(s.charAt(0)=='.') break;
            Deque<Character> stack = new ArrayDeque<>();
            boolean flag = true;
            for(char c : s.toCharArray()){
                if(c=='(' || c=='['){ //왼쪽 괄호인경우
                    stack.add(c);
                }else if(c==')' || c==']'){ //오른쪽 괄호인 경우
                    if(stack.isEmpty() || (c==')' && stack.peekLast()=='[') || (c==']' && stack.peekLast()=='(')){
                        sb.append("no").append("\n");
                        flag = false;
                        break;
                    }
                    stack.pollLast();
                }
            }
            if(flag && !stack.isEmpty()){
                sb.append("no").append("\n");
                flag = false;
            }
            if(flag) sb.append("yes").append("\n");
        }
        System.out.println(sb);
    }
}
