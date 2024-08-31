import java.util.*;
import java.io.*;

public class Main {
    static int W;
    static int H;
    static char[][] graph;
    static boolean[][] visited;
    static int[][] fire;
    static Queue<Node> queue;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[] dS;
    static StringBuffer sb;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());
        for(int t =0;t<T;t++){
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            graph = new char[H][W];
            visited = new boolean[H][W];
            fire = new int[H][W];
            queue = new ArrayDeque<>();

            for(int i=0;i<H;i++){
                String s = br.readLine();
                for(int j=0;j<W;j++){
                    char c = s.charAt(j);
                    graph[i][j] =c;
                    switch(c){
                        case '@':
                            dS = new int[]{i,j};
                            break;
                        case '*':
                            queue.add(new Node(i,j,1));
                            visited[i][j] = true;
                            fire[i][j] = 1;
                            break;
                    }
                }
            }
            FireBFS();
            visited = new boolean[H][W];
            queue.add(new Node(dS[0],dS[1],1));
            BFS();
        }
        System.out.println(sb);
    }
    static void FireBFS(){
        while(!queue.isEmpty()){
            Node n = queue.poll();
            for(int i=0;i<4;i++){
                int xi = n.x + dx[i];
                int yi = n.y + dy[i];
                if(xi<0 || xi>=H||yi<0 || yi>=W) continue;
                if(graph[xi][yi]=='#' || visited[xi][yi]) continue;
                queue.add(new Node(xi,yi,n.cnt+1));
                visited[xi][yi] = true;
                fire[xi][yi] = n.cnt+1;
            }
        }
    }
    static void BFS(){
        while(!queue.isEmpty()){
            Node n = queue.poll();
            if(n.x==0 || n.x==H-1 || n.y==0 ||n.y==W-1){
                sb.append(n.cnt).append("\n");
                return;
            }
            for(int i=0;i<4;i++){
                int xi = n.x + dx[i];
                int yi = n.y + dy[i];
                if(xi<0 || xi>=H||yi<0 || yi>=W) continue;
                if(graph[xi][yi]!='.' || visited[xi][yi]) continue;
                if(fire[xi][yi]>0 && fire[xi][yi] <= n.cnt+1) continue;
                queue.add(new Node(xi,yi,n.cnt+1));
                visited[xi][yi] = true;
            }
        }
        sb.append("IMPOSSIBLE").append("\n");
    }
    static class Node{
        int x;
        int y;
        int cnt;
        Node(int x,int y,int cnt){
            this.x = x;
            this.y =y;
            this.cnt =cnt;
        }
    }
}
