import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        int answer= 0;
        // 스택 생성
        Deque<Integer> stack = new ArrayDeque<>();
        for(int k=0;k<K;k++){
            int num = Integer.parseInt(br.readLine());
            if(num != 0) stack.add(num);
            else stack.pollLast();
        }

        while(!stack.isEmpty()){
            answer+= stack.poll();
        }

        System.out.println(answer);
    }
}
