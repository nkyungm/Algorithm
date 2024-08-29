import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int H;
    static int[][][] graph;
    static boolean[][][] visited;
    static Queue<Tomato> queue;
    static int[] dx = {1,-1,0,0,0,0};
    static int[] dy = {0,0,1,-1,0,0};
    static int[] dh = {0,0,0,0,1,-1};
    static int zeroCnt=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        graph = new int[H][N][M];
        visited = new boolean[H][N][M];
        queue = new ArrayDeque<>();

        for(int h=0;h<H;h++){
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<M;j++){
                    int num = Integer.parseInt(st.nextToken());
                    graph[h][i][j] = num;
                    switch(num){
                        case 0:
                            zeroCnt++;
                            break;
                        case 1:
                            visited[h][i][j] = true;
                            queue.add(new Tomato(h,i,j,0));
                            break;
                    }
                }
            }
        }
        if(zeroCnt ==0) {
            System.out.println(0);
            return;
        }
        System.out.println(bfs());
    }
    static int bfs(){
        int tomatoCnt = 0;
        while(!queue.isEmpty()){
            Tomato t = queue.poll();
            for(int i=0;i<6;i++){
                int xi = t.x + dx[i];
                int yi = t.y + dy[i];
                int hi = t.h + dh[i];

                if(xi <0 || xi>=N || yi<0 || yi>=M || hi<0 || hi >=H) continue;
                if(graph[hi][xi][yi]!=0 || visited[hi][xi][yi]) continue;

                visited[hi][xi][yi] = true;
                tomatoCnt ++;
                queue.add(new Tomato(hi,xi,yi,t.cnt+1));
                if(tomatoCnt == zeroCnt) return t.cnt+1;
            }
        }
        return -1;
    }
    static class Tomato{
        int x;
        int y;
        int h;
        int cnt;
        Tomato(int h,int x,int y,int cnt){
            this.x = x;
            this.y =y;
            this.h = h;
            this.cnt =cnt;
        }
    }
}
