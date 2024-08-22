import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        long answer = 0;
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<int[]> stack = new ArrayDeque<>();

        // 입력 숫자 넣기
        for(int n=0;n<N;n++) numStack.add(Integer.parseInt(br.readLine()));

        // 반복문 돌리기
        for(int i=N;i>0;i--){
            int num = numStack.pollLast();
            // 스택에 값 있는 경우
            while(!stack.isEmpty()){
                int[] front = stack.peekLast();
                // num이 같거나 작은 경우 -> 스택에 넣고 중단
                if(num <= front[0]){
                    answer += (front[1]-i-1);
                    stack.add(new int[]{num,i});
                    break;
                }
                // num이 더 큰 경우 -> 빼면서 answer++
                stack.pollLast();
            }
            // 비었으면 스택에 넣기
            if(stack.isEmpty()) {
                answer += (N - i);
                stack.add(new int[]{num,i});
            }
        }
        System.out.println(answer);
    }
}
