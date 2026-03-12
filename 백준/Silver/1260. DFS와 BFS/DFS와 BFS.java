import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] arr;
    static int N;
    static int M;
    static int V;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            arr[v1][v2] = true;
            arr[v2][v1] = true;
        }

        DFS(V);
        sb.append("\n");
        BFS();

        System.out.println(sb);

    }

    private static void DFS(int v){
        visited[v] = true;
        sb.append(v).append(" ");

        for(int i=1;i<N+1;i++){
            if(arr[v][i] && !visited[i]){
                DFS(i);
            }
        }
    }


    private static void BFS(){
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];

        queue.offer(V);
        visited[V] = true;

        while(!queue.isEmpty()){
            int v = queue.poll();
            sb.append(v).append(" ");
            for(int v1=1;v1<N+1;v1++){
                if(!arr[v][v1]) continue;
                if(!visited[v1]){
                    queue.offer(v1);
                    visited[v1] = true;
                }
            }
        }
    }
}
