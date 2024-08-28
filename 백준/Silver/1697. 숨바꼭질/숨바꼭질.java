import java.util.*;
import java.io.*;

public class Main {
    static boolean[] graph;
    static boolean[] visited;
    static int N;
    static int K;
    static Queue<int[]> queue;
    static int[] dx = {2,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        queue = new ArrayDeque<>();

        graph = new boolean[200001];
        visited = new boolean[200001];

        visited[N] = true;
        queue.add(new int[]{N,0});

        System.out.println(bfs());
    }
    static int bfs(){
        while(!queue.isEmpty()){
            int[] n = queue.poll();
            if(n[0] == K) return n[1];

            int xi = n[0]*2;
            if(xi >=0 && xi<200000 && !visited[xi]) {
                visited[xi] = true;
                queue.add(new int[]{xi,n[1]+1});
            }
            xi = n[0]+1;
            if(xi >=0 && xi<200000 && !visited[xi]) {
                visited[xi] = true;
                queue.add(new int[]{xi,n[1]+1});
            }
            xi = n[0]-1;
            if(xi >=0 && xi<200000 && !visited[xi]) {
                visited[xi] = true;
                queue.add(new int[]{xi,n[1]+1});
            }

        }
        return -1;
    }
}
