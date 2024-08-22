import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        Deque<int[]> stack = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n=1;n<=N;n++){
            int num = Integer.parseInt(st.nextToken());
            // stack에 없을때까지 뽑기
            while(!stack.isEmpty()){
                int[] front = stack.peekLast();
                // num보다 크거나 같으면 stack에 넣고 front의 idx 출력
                if(num <= front[0]){
                    stack.add(new int[]{num,n});
                    sb.append(front[1]).append(" ");
                    break;
                }
                // num보다 작으면 계속 빼기
                stack.pollLast();
            }
            // stack에 아무것도 없으면 0 출력
            if(stack.isEmpty()){
                sb.append("0 ");
                stack.add(new int[]{num,n});
            }
        }
        System.out.println(sb);
    }
}
