import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        //스택 생성
        Deque<Integer> stack = new ArrayDeque<>();
        int idx= 1;
        for(int n=0;n<N;n++){
            int num = Integer.parseInt(br.readLine());
            //idx보다 큰 경우 => 스택에 넣기
            if(idx <= num){
                while(idx <= num){
                    stack.add(idx);
                    idx++;
                    sb.append("+").append("\n");
                }
                stack.pollLast(); // idx 수 빼주기
                sb.append("-").append("\n");
            }else{ // idx보다 같거나 작은경우 => stack.pollLast()해서 같으면 빼고 아니면 종료
                if(stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                }
                int num2 = stack.pollLast();
                if(num != num2) {
                    System.out.println("NO");
                    return;
                }
                sb.append("-").append("\n");
            }
        }
        System.out.println(sb);
    }
}
