import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] graph;
    static boolean[][] visited;
    static Queue<int[]> queue;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int answer=1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N= Integer.parseInt(br.readLine());
        graph = new int[N][N];
        queue = new ArrayDeque<>();
        int minNum=101;
        int maxNum=0;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int num = Integer.parseInt(st.nextToken());
                graph[i][j] = num;
                maxNum = Math.max(num,maxNum);
                minNum = Math.min(num,minNum);
            }
        }
        for(int k=minNum;k<=maxNum;k++){
            visited = new boolean[N][N];
            int cnt =0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(graph[i][j]<k || visited[i][j]) continue;
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;
                    bfs(k);
                    cnt++;
                }
            }
            answer = Math.max(answer,cnt);
        }
        System.out.println(answer);

    }
    static void bfs(int k){
        while(!queue.isEmpty()){
            int[] v = queue.poll();
            for(int i=0;i<4;i++){
                int xi = v[0] + dx[i];
                int yi = v[1] + dy[i];
                if(xi<0 || xi>=N || yi<0 || yi>=N) continue;
                if(graph[xi][yi]<k || visited[xi][yi]) continue;
                queue.add(new int[]{xi,yi});
                visited[xi][yi] = true;
            }
        }
    }
}
