import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            String s = br.readLine();
            Deque<Character> stack = new ArrayDeque<>();

            boolean flag = true;
            for(char c : s.toCharArray()){
                if(c=='('){
                    stack.add(c);
                }else if(c==')'){
                    if(stack.isEmpty() || stack.peekLast() != '(') {
                        flag = false;
                        break;
                    }
                    stack.pollLast();
                }
            }
            if(!stack.isEmpty()) flag = false;
            if(flag) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }
}
