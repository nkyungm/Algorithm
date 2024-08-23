import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        // 큐 생성
        Deque<Integer> queue = new ArrayDeque<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String commend = st.nextToken();
            switch(commend){
                case "pop":
                    if(queue.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(queue.pollFirst()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if(queue.isEmpty()) sb.append("1").append("\n");
                    else sb.append("0").append("\n");
                    break;
                case "front":
                    if(queue.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(queue.peekFirst()).append("\n");
                    break;
                case "back":
                    if(queue.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(queue.peekLast()).append("\n");
                    break;
                case "push":
                    int n = Integer.parseInt(st.nextToken());
                    queue.add(n);
                    break;
            }
        }
        System.out.println(sb);
    }
}
