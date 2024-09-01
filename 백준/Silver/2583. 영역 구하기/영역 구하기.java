import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int K;
    static boolean[][] graph;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new boolean[N][M];
        visited = new boolean[N][M];
        queue = new ArrayDeque<>();

        for(int k=0;k<K;k++){
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            for(int i=startX;i<endX;i++){
                for(int j=startY;j<endY;j++){
                    graph[i][j] = true;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(graph[i][j] || visited[i][j]) continue;
                queue.add(new int[]{i,j});
                visited[i][j] = true;
                list.add(bfs());
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }
    static int bfs(){
        int cnt = 1;
        while(!queue.isEmpty()){
            int[] v = queue.poll();
            for(int i=0;i<4;i++){
                int xi = v[0] + dx[i];
                int yi = v[1] + dy[i];
                if(xi<0 || xi>=N || yi<0 || yi>=M) continue;
                if(graph[xi][yi] || visited[xi][yi]) continue;
                queue.add(new int[]{xi,yi});
                visited[xi][yi] = true;
                cnt++;
            }
        }
        return cnt;
    }
}
