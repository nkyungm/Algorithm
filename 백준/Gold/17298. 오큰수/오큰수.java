import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        // 수 담을 스택
        int[] answer = new int[N];
        // 정답 계산에 이용한 스택
        Deque<Integer> stack = new ArrayDeque<>();
        // 정답 담을 배열

        // 숫자 담기
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) answer[i] = Integer.parseInt(st.nextToken());

        // 오른쪽부터 계산 시작
        for(int i=N-1;i>=0;i--){
            int num = answer[i];
            while(!stack.isEmpty()){
                // 스택에서 맨위에 있는거 빼기
                int back = stack.peekLast();
                if(num < back){ // back이 더 큰경우 -> 멈추고 저장, 스택에 넣기
                    answer[i] =  back;
                    stack.add(num);
                    break;
                }
                stack.pollLast();
            }
            if(stack.isEmpty()){
                answer[i] = -1;
                stack.add(num);
            }
        }

        for(int i=0;i<N;i++){
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}
