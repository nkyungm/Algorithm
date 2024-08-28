import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] graph;
    static boolean[][] visited;
    static int N;
    static int M;
    static Queue<int[]> queue;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new boolean[N][M];
        visited = new boolean[N][M];
        queue = new ArrayDeque<>();
        int MAX =0;
        int cnt =0;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                String s = st.nextToken();
                graph[i][j] = s.equals("1") ?true : false ;
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!graph[i][j] | visited[i][j]) continue;
                queue.add(new int[]{i,j});
                visited[i][j] = true;
                MAX = Math.max(MAX,bfs());
                cnt++;
            }
        }

        System.out.println(cnt);
        System.out.println(MAX);
    }
    static int bfs(){
        int cnt =0;

        while(!queue.isEmpty()){
            int[] v = queue.poll();
            cnt ++;
            for(int i=0;i<4;i++){
                int xi = v[0] + dx[i];
                int yi = v[1] + dy[i];

                if(xi <0 || xi >= N || yi <0 || yi>=M) continue;
                if(!graph[xi][yi] || visited[xi][yi]) continue;
                visited[xi][yi] = true;
                queue.add(new int[]{xi,yi});
            }
        }

        return cnt;

    }
}
