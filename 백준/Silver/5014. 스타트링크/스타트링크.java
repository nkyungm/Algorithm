import java.util.*;
import java.io.*;
public class Main {
    static int F;
    static int S;
    static int G;
    static int U;
    static int D;
    static boolean[] visited;
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[F+1];
        queue = new ArrayDeque<>();

        bfs();
    }
    static void bfs(){
        queue.add(new int[]{S,0});
        visited[S] = true;
        while(!queue.isEmpty()){
            int[] v = queue.poll();
            if(v[0]==G) {
                System.out.println(v[1]);
                return;
            }
            int xi = v[0] + U;
            if(xi>=1 && xi<=F && !visited[xi]){
                queue.add(new int[]{xi,v[1]+1});
                visited[xi] = true;
            }
            xi = v[0] - D;
            if(xi>=1 && xi<=F && !visited[xi]){
                queue.add(new int[]{xi,v[1]+1});
                visited[xi] = true;
            }
        }
        System.out.println("use the stairs");
    }
}
