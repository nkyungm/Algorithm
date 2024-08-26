import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int answer = 0; // 전체 개수 저장 위함
        Deque<Character> stack = new ArrayDeque<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            // 1. ( 인경우 -> 스택에 넣기, Scnt 초기화
            if(c=='('){
                stack.add(c);
                continue;
            }
            // 2. ) 인경우
            stack.pollLast(); // 미리 꺼내주기
            if(s.charAt(i-1) == '('){ // 1번 경우
                answer += stack.size();
            }else answer++;

            // System.out.println(Scnt+ " "+Lcnt+" "+answer);
        }

        System.out.println(answer);
    }
}
