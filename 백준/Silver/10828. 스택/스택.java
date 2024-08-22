import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<String> stack = new ArrayDeque<>();

        for(int n=0;n<N;n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String commend = st.nextToken();
            switch(commend){
                case "pop": // 스택에서 가장 위에 있는 정수 빼기, 수 출력, 없으면 -1
                    if(stack.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(stack.pollLast()).append("\n");
                    break;
                case "size": // 스택 들어있는 정수 개수 출력
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty": // 스택 비어있으면 1, 아니면 0
                    if(stack.isEmpty()) sb.append("1").append("\n");
                    else sb.append("0").append("\n");
                    break;
                case "top": // 스택 가장 위에 있는 정수 출력(빼진 않음), 없으면 -1
                    if(stack.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(stack.peekLast()).append("\n");
                    break;
                case "push": // 정수 X 스택에 넣기
                    String X = st.nextToken();
                    stack.add(X);
                    break;
            }
        }
        System.out.println(sb);
    }
}
