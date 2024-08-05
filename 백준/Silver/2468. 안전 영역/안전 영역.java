import java.io.*;
import java.util.*;
import java.lang.*;

/**
 * 1. 최대 높이 얻기
 * 2. BFS로 끝날때마다 count+1
 * 3. 최대 높이 -1 까지 하면서 최대값 찾기
 */

public class Main {
    static int N;
    static int[][] graph;
    static int max_rain=0;
    static int min_rain=100;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean[][] visited;
    static int answer=1;
    static Queue<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                max_rain = Math.max(max_rain,graph[i][j]); //java.lang.* 중요
                min_rain = Math.min(min_rain,graph[i][j]);
            }
        }

        for(int i=min_rain;i<max_rain;i++){
            int cnt = 0;
            for(int j=0;j<N;j++) {
                for (int k = 0; k < N; k++) {
                    if (visited[j][k] || graph[j][k] <= i) continue;
                    queue.add(new int[]{j, k});
                    visited[j][k] = true;
                    cnt++;
                    bfs(i);
                }
            }
            answer = Math.max(answer,cnt);
            visited = new boolean[N][N];
        }

        System.out.println(answer);
    }
    static void bfs(int target_rain){
        while(!queue.isEmpty()){
            int[] v = queue.poll();
            for(int i=0;i<4;i++){
                int xi = dx[i] + v[0];
                int yi = dy[i] + v[1];
                if(xi <0 || xi>=N || yi <0 || yi>=N) continue;
                if(visited[xi][yi] || graph[xi][yi] <= target_rain) continue;
                queue.add(new int[]{xi,yi});
                visited[xi][yi] = true;
            }
        }
    }
}
