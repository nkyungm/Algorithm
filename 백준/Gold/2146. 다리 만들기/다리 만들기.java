import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] graph;
    static boolean[][] visited;
    static boolean[][] visited2;
    static Queue<int[]> queue;
    static Queue<int[]> queue2;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =null;
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];
        visited2 = new boolean[N][N]; // 찾을때 쓰는 방문처리 배열
        queue = new ArrayDeque<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int num = Integer.parseInt(st.nextToken());
                graph[i][j] = num;
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(graph[i][j]==0 || visited[i][j]) continue;
                queue.add(new int[]{i,j});
                visited[i][j] = true;

                visited2 = new boolean[N][N];
                queue2 = new ArrayDeque<>();
                queue2.add(new int[]{i,j,0});
                visited2[i][j] = true;
                bfs();
            }
        }
        System.out.println(answer);
    }
    static void bfs(){
        while(!queue.isEmpty()){
            int[] v = queue.poll();
            for(int i=0;i<4;i++){
                int xi = v[0] + dx[i];
                int yi = v[1] + dy[i];
                if(xi<0 || xi>=N || yi<0 || yi>=N) continue;
                if(graph[xi][yi]==0 || visited[xi][yi]) continue;
                queue.add(new int[]{xi,yi});
                queue2.add(new int[]{xi,yi,0});
                visited[xi][yi] = true;
                visited2[xi][yi] = true;
            }
        }
        answer = Math.min(go(),answer);
    }
    static int go(){
        while(!queue2.isEmpty()){
            int[] v = queue2.poll();
            for(int i=0;i<4;i++){
                int xi = v[0] + dx[i];
                int yi = v[1] + dy[i];
                if(xi<0 || xi>=N || yi<0 || yi>=N) continue;
                if(visited2[xi][yi]) continue;
                if(graph[xi][yi]==1) return v[2];
                queue2.add(new int[]{xi,yi,v[2]+1});
                visited2[xi][yi] = true;
            }
        }
        return -1;
    }
}
