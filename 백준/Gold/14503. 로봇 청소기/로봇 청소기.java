import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Robot{
    int r;
    int c;
    int d;
    public Robot(int r, int c,int d) {
        this.r = r;
        this.c = c;
        this.d = d;
    }

    public Robot() {
    }
}

public class Main {
    static int N,M;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int cnt =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                graph[i][j] = num;
                if(num ==1) visited[i][j] = true;
            }
        }

        BFS(new Robot(r,c,d));
        System.out.println(cnt);

    }
    private static void BFS(Robot rb){
        Queue<Robot> queue = new ArrayDeque<>();
        queue.add(rb);

        while(!queue.isEmpty()){
            boolean bin = false;
            Robot v = queue.poll();
            // 1. 현재 칸 청소
            if(graph[v.r][v.c] ==0){
                visited[v.r][v.c] = true;
                graph[v.r][v.c] =2; //2 : 청소한것
                cnt ++;
            }
            // 현재 칸의 주변 4칸 탐색
            for (int i = 0; i < 4; i++) {
                int xi = v.r + dx[i];
                int yi = v.c + dy[i];
                if(xi>=0 && xi <N && yi>=0 && yi<M){
                    // 3. 청소안한 칸이 있는 경우
                    if(!visited[xi][yi] && graph[xi][yi]==0){
                        bin = true;
                    }
                }
            }
            // 3. 청소안한 칸 있는 경우
            if(bin) {
                // 반시계방향 90도 회전
                int di = (v.d==0 ? 3: v.d-1);
                // 바라보는 방향 기준 앞칸 청소X, 빈칸  -> 전진
                int xi = v.r + dx[di];
                int yi = v.c + dy[di];
                if(xi >=0 && xi<N && yi>=0 && yi<M){
                    if(graph[xi][yi]==0 && !visited[xi][yi]){
                        // 한칸 전진
                        queue.add(new Robot(xi,yi,di));
                    }else{
                        queue.add(new Robot(v.r,v.c,di));
                    }
                }
            }
            // 2. 현재 칸의 주변 4칸중 청소되지 않은 빈칸 없는 경우
            else{
                // 후진
                int di = (v.d == 0 || v.d == 1 ) ? v.d +2 : v.d-2;
                int xi = v.r + dx[di];
                int yi = v.c + dy[di];

                if(xi >= 0 & xi<N&& yi>=0 && yi<M){
                    // 후진할 수 있다면(벽이 아니라면)
                    if(graph[xi][yi] !=1){
                        queue.add(new Robot(xi,yi,v.d));
                    }else{
                        return;
                    }
                }
            }
        }
    }
}
