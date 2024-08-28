import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] graph;
    static boolean[][] visited;
    static int N;
    static int M;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static Queue<Node> queue;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new boolean[N][M];
        visited = new boolean[N][M];
        queue = new ArrayDeque<>();

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                char c = s.charAt(j);
                graph[i][j] = c=='1' ? true:false;
            }
        }

        queue.add(new Node(0,0,1));
        visited[0][0] = true;
        System.out.println(bfs());
    }
    static int bfs(){
        while(!queue.isEmpty()){
            Node n = queue.poll();
            if(n.x == N-1 && n.y==M-1){
                return n.cnt;
            }
            for(int i=0;i<4;i++){
                int xi = n.x + dx[i];
                int yi = n.y + dy[i];
                if(xi <0 || xi >=N || yi<0 || yi>=M) continue;
                if(!graph[xi][yi] || visited[xi][yi]) continue;
                visited[xi][yi] = true;
                queue.add(new Node(xi,yi,n.cnt+1));
            }
        }
        return 0;
    }
    static class Node{
        int x;
        int y;
        int cnt;

        Node(int x,int y,int cnt){
            this.x = x;
            this.y =y;
            this.cnt = cnt;
        }
    }
}
