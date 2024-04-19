import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =null;
        StringBuffer sb = new StringBuffer();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int com = Integer.parseInt(br.readLine());
            if(com ==0){
                if(pq.isEmpty()) sb.append("0").append("\n");
                else{
                    sb.append(pq.poll()).append("\n");
                }
            }else{
                pq.add(com);
            }

        }
        System.out.println(sb);

    }
}
