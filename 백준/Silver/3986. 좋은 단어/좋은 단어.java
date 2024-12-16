import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int i=0;i<N;i++){
            ArrayDeque<Character> stack= new ArrayDeque<>();
            String s = br.readLine();
            // 홀수면 넘기기
            if(s.length()%2!=0) continue;
            for(char c : s.toCharArray()){
                // 스택이 비어있으면 넣기
                if(stack.isEmpty()) stack.offerLast(c);
                else{
                    // 비어있지 않은경우
                    // 1. 스택 맨위에 있는거 꺼내기
                    char last = stack.peekLast();
                    // 2. 같으면 빼고 다르면 넣기
                    if(last == c) stack.pollLast();
                    else stack.offerLast(c);
                }
            }
            if(stack.isEmpty()) answer++;
        }

        System.out.println(answer);


    }
}
