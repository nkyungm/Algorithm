import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int i=0;i<N;i++){
            String s = br.readLine();
            Deque<Character> stack = new ArrayDeque<>();
            boolean flag = true;
            for(char c : s.toCharArray()){
                if(stack.isEmpty()){
                    stack.add(c);
                    continue;
                }
                if(c=='A'){
                    int num = stack.peekLast();
                    if(num!='A') {
                        stack.add(c);
                        continue;
                    }
                    stack.pollLast();
                }else{
                    int num = stack.peekLast();
                    if(num!='B') {
                        stack.add(c);
                        continue;
                    }
                    stack.pollLast();
                }
            }
            if(stack.isEmpty()) answer++;
        }

        System.out.println(answer);
    }
}
