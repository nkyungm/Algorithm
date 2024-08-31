import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static char[][] graph;
    static boolean[][] visited;
    static Queue<int[]> queue;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];
        visited = new boolean[N][N];
        queue= new ArrayDeque<>();

        for(int i=0;i<N;i++) {
            String s = br.readLine();
            for(int j=0;j<N;j++){
                char c = s.charAt(j);
                graph[i][j] = c;
            }
        }

        // 적록색약 아닌사람
        int cnt = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++){
                if(visited[i][j]) continue;
                queue.add(new int[]{i,j});
                visited[i][j] = true;
                bfs(graph[i][j]);
                cnt++;
            }
        }
        sb.append(cnt).append(" ");

        visited = new boolean[N][N];
        cnt = 0;
        // 적록색약 아닌사람
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++){
                if(visited[i][j]) continue;
                queue.add(new int[]{i,j});
                visited[i][j] = true;
                bfs2(graph[i][j]);
                cnt++;
            }
        }
        sb.append(cnt);

        System.out.println(sb);

    }
    static void bfs(char color){
        while(!queue.isEmpty()){
            int[] v = queue.poll();
            for(int i=0;i<4;i++){
                int xi = v[0] + dx[i];
                int yi = v[1] + dy[i];
                if(xi<0 || xi>=N || yi<0 || yi>=N) continue;
                if(graph[xi][yi] != color || visited[xi][yi]) continue;
                queue.add(new int[]{xi,yi});
                visited[xi][yi] = true;
            }
        }
    }
    static void bfs2(char color){
        while(!queue.isEmpty()){
            int[] v = queue.poll();
            for(int i=0;i<4;i++){
                int xi = v[0] + dx[i];
                int yi = v[1] + dy[i];
                if(xi<0 || xi>=N || yi<0 || yi>=N) continue;
                if(visited[xi][yi]) continue;
                if(color=='B'){
                    if(graph[xi][yi] != color ) continue;
                }else{
                    if(graph[xi][yi] == 'B') continue;
                }

                queue.add(new int[]{xi,yi});
                visited[xi][yi] = true;
            }
        }
    }
}
