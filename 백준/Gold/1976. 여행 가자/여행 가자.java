import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    //플로이드 워샬 알고리즘 활용
    static int N,M;
    static boolean[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new boolean[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                graph[i][j] = (num ==1);
            }
            graph[i][i] = true;
        }
        floyd();

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M-1; i++) {
            if(!graph[arr[i]][arr[i+1]]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }
    static void floyd(){
        // k: 경유지
        for (int k = 1; k <=N ; k++) {
            for (int i = 1; i <=N ; i++) { //i: 출발지
                for (int j = 1; j <=N ; j++) { // j: 도착지
                    if(graph[i][k] && graph[k][j]) graph[i][j] = true;
                }
            }
        }
    }
}
