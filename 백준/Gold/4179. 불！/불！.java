import java.util.*;
import java.io.*;

public class Main {
    static int R;
    static int C;
    static char[][] graph;
    static boolean[][] visited;
    static int[][] fire;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[] dJ;
    static int[] dF;
    static Queue<Node> queue;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new char[R][C];
        visited = new boolean[R][C];
        fire = new int[R][C];
        queue = new ArrayDeque<>();

        for(int i=0;i<R;i++){
            String s = br.readLine();
            for(int j=0;j<C;j++){
                char c = s.charAt(j);
                graph[i][j] = c;
                switch(c){
                    case 'J':
                        dJ = new int[]{i,j};
                        break;
                    case 'F':
                        dF = new int[]{i,j};
                        queue.add(new Node(dF[0],dF[1],1));
                        visited[i][j] = true;
                        fire[i][j] = 1;
                        break;
                }
            }
        }
        fireBFS();
        visited = new boolean[R][C];
        queue.add(new Node(dJ[0],dJ[1],1));
        visited[dJ[0]][dJ[1]] = true;
        int answer = JBFS();
        if(answer == -1) System.out.println("IMPOSSIBLE");
        else System.out.println(answer);
    }
    static void fireBFS(){
        while(!queue.isEmpty()){
            Node f = queue.poll();
            for(int i=0;i<4;i++){
                int xi = f.x + dx[i];
                int yi = f.y + dy[i];
                if(xi <0 || xi>=R || yi<0 || yi>=C) continue;
                if(graph[xi][yi] == '#' || visited[xi][yi]) continue;
                queue.add(new Node(xi,yi,f.cnt+1));
                visited[xi][yi] = true;
                fire[xi][yi] = f.cnt+1;
            }
        }
    }
    static int JBFS(){
        while(!queue.isEmpty()){
            Node v = queue.poll();
            // 탈출조건
            if(v.x == 0 || v.y == 0 || v.x==R-1 || v.y ==C-1){
                return v.cnt;
            }
            for(int i=0;i<4;i++){
                int xi = v.x + dx[i];
                int yi = v.y + dy[i];
                if(xi <0 || xi>=R || yi<0 || yi>=C) continue;
                if(graph[xi][yi]!= '.' || visited[xi][yi]) continue;
                if(fire[xi][yi] > 0 && fire[xi][yi] <= v.cnt+1) continue;
                queue.add(new Node(xi,yi,v.cnt+1));
                visited[xi][yi] = true;
            }
        }
        return -1;
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
