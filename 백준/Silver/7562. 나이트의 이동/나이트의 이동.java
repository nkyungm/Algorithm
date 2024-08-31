import java.util.*;
import java.io.*;

public class Main {
    static int I;
    static boolean[][] visited;
    static Queue<Node> queue;
    static int[] endPoint;
    static int[] dx = {-2,-1,-2,-1,1,2,1,2};
    static int[] dy = {-1,-2,1,2,-2,-1,2,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            I = Integer.parseInt(br.readLine());
            visited = new boolean[I][I];
            queue = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            queue.add(new Node(x,y,0));
            visited[x][y] = true;

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            endPoint = new int[]{x,y};

            sb.append(BFS()).append("\n");
        }
        System.out.println(sb);
    }
    static int BFS(){
        while(!queue.isEmpty()){
            Node v= queue.poll();
            if(v.x == endPoint[0] && v.y == endPoint[1]) return v.cnt;
            for(int i=0;i<8;i++){
                int xi = v.x + dx[i];
                int yi = v.y + dy[i];
                if(xi<0 || xi>=I || yi<0 || yi>=I) continue;
                if(visited[xi][yi]) continue;
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
            this.y= y;
            this.cnt =cnt;
        }
    }
}
