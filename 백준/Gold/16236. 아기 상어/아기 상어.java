import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] graph;
    static Node babyShark;
    static int babySharkSize=2;
    static int[] fish;
    static boolean[][] visited;
    static int count = 0;
    static int eatFishCnt = 0;
    static int[] dx = {-1,0,0,1}; //위, 왼, 오, 아래
    static int[] dy = {0,-1,1,0};
    static class Node implements Comparable<Node>{
        int x,y,d;

        public Node(int x, int y,int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            if(this.d == o.d){
                if(this.x == o.x) return this.y - o.y;
                return this.x - o.x;
            }
            return this.d - o.d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =null;

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];
        fish = new int[7];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                // 아기상어 위치
                if(graph[i][j] ==9) babyShark = new Node(i,j,0);
                // 물고기들의 크기별 개수 저장
                if(graph[i][j] !=9 && graph[i][j]!=0){
                    fish[graph[i][j]] ++;
                }
            }
        }

        // 처음에 크기가 1인 물고기가 없는 경우
        if(fish[1] == 0) {
            System.out.println(0);
            return;
        }

        // 크기가 1인 물고기가 여러마리인 경우
        // 먹을 수 있는 물고기가 없을때까지 반복
        int cnt =fish[1];
        eatFishCnt = 0;
        babySharkSize = 2;
        count = 0;
        while(cnt !=0){
            visited = new boolean[N][N];
            if(!findFish(babyShark)) break; //BFS

            // 아기상어 크기 체크
            if(eatFishCnt == babySharkSize) {
                if(babySharkSize < 7) babySharkSize++;
                eatFishCnt = 0;
            }

            cnt = 0;
            for (int i = 1; i < babySharkSize ; i++) {
                cnt += fish[i];
            }
        }
        System.out.println(count);
    }
    static boolean findFish(Node n) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(n);
        visited[n.x][n.y] = true;

        while (!queue.isEmpty()) {
            Node v = queue.poll();

            // 먹을 수 있는 물고기인 경우
            if(graph[v.x][v.y] > 0 && graph[v.x][v.y] < babySharkSize) {
                eatFishCnt ++; //먹은 개수 추가
                // 시간 추가
                count += v.d;
                fish[graph[v.x][v.y]] --;
                graph[babyShark.x][babyShark.y] = 0;
                graph[v.x][v.y] = 9;

                babyShark = new Node(v.x,v.y,0); // 자리 이동

                return true;
            }

            for (int i = 0; i < 4; i++) {
                int xi = v.x + dx[i];
                int yi = v.y + dy[i];

                if(xi<0 || xi >=N || yi <0 || yi >=N) continue;
                if(visited[xi][yi] || graph[xi][yi] > babySharkSize) continue;
                visited[xi][yi] = true;
                queue.add(new Node(xi,yi,v.d+1));
            }
            //
        }
        return false;
    }
}
