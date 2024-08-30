import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] graph;
    static boolean[][] visited;
    static int N;
    static int M;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static Queue<int[]> queue ;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            graph = new boolean[N][M];
            visited = new boolean[N][M];
            queue = new ArrayDeque<>();
            int K = Integer.parseInt(st.nextToken());
            int answer = 0;

            for(int k=0;k<K;k++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[x][y] = true;
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(!graph[i][j] || visited[i][j] ) continue;
                    answer++;
                    visited[i][j] = true;
                    queue.add(new int[]{i,j});
                    bfs();
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
    static void bfs(){
        while(!queue.isEmpty()){
            int[] v = queue.poll();
            for(int i=0;i<4;i++){
                int xi = v[0] + dx[i];
                int yi = v[1] + dy[i];
                if(xi<0 || xi>=N|| yi<0 || yi>=M) continue;
                if(!graph[xi][yi] || visited[xi][yi] ) continue;
                visited[xi][yi] = true;
                queue.add(new int[]{xi,yi});
            }
        }
    }
}
