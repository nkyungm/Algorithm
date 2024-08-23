import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();

        // 큐에 다 넣기
        for(int i=1;i<=N;i++) queue.add(i);

        // while문으로 size가 1일떄까지 반복
        while(queue.size() > 1){
            // 1번째 - 제일 위 카드 바닥에 버림
            queue.poll();
            // 그 뒤에 size==1이면 종료
            if(queue.size() ==1) {
                System.out.println(queue.poll());
                return;
            }
            // 2번째 - 제일 위의 카드를 빼서 제일 뒤에 넣기
            int num = queue.poll();
            queue.add(num);
        }
        System.out.println(queue.poll());
    }
}
