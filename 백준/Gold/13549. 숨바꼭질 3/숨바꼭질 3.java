import java.util.*;
import java.io.*;

// 우선순위 큐 사용하기
public class Main {
    static int N;
    static int K;
    static boolean[] visited;
    static Deque<int[]> queue;
    public static void main(String[] args) throws IOException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        queue = new ArrayDeque<>();

        queue.add(new int[]{N,0});
        visited[N] = true;
        System.out.println(bfs());
    }
    static int bfs(){
        while(!queue.isEmpty()){
            int[] v = queue.pollFirst();
            if(v[0]==K){
                return v[1];
            }
            int xi = v[0]*2;
            if(xi<=100000 && !visited[xi]){
                queue.addFirst(new int[]{xi,v[1]});
                visited[xi] = true;
            }
            xi = v[0]-1;
            if(xi>=0 && xi<=100000 && !visited[xi]){
                queue.addLast(new int[]{xi,v[1]+1});
                visited[xi] = true;
            }
            xi = v[0]+1;
            if(xi>=0 && xi<=100000 && !visited[xi]){
                queue.addLast(new int[]{xi,v[1]+1});
                visited[xi] = true;
            }
        }
        return 0;
    }
}
