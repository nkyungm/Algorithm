import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static Queue<Tomato> queue;
    static int zeroCnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M];
        queue = new ArrayDeque<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int num = Integer.parseInt(st.nextToken());
                graph[i][j] = num;
                switch(num){
                    case 0:
                        zeroCnt++;
                        break;
                    case 1:
                        queue.add(new Tomato(i,j,0));
                        visited[i][j] = true;
                        break;
                }
            }
        }
        if(zeroCnt==0){
            System.out.println(0);
            return;
        }
        System.out.println(bfs());

    }
    static int bfs(){
        int tomatoCnt = 0;

        while(!queue.isEmpty()){
            Tomato t = queue.poll();

            for(int i=0;i<4;i++){
                int xi = t.x + dx[i];
                int yi = t.y + dy[i];
                if(xi <0 || xi>=N || yi<0 || yi>=M) continue;
                if(graph[xi][yi]!=0 || visited[xi][yi]) continue;
                visited[xi][yi] = true;
                tomatoCnt ++;
                queue.add(new Tomato(xi,yi,t.cnt+1));
                if(tomatoCnt == zeroCnt){
                    return t.cnt+1;
                }
            }
        }
        return -1;
    }
    static class Tomato{
        int x;
        int y;
        int cnt;
        Tomato(int x,int y,int cnt){
            this.x = x;
            this.y= y;
            this.cnt = cnt;
        }
    }
}
