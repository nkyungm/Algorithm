import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R,C,T;
    static int[][] graph;
    static int[][] tempArr;
    static List<Integer> airCleaner;
    static Queue<Node> queue;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[] dx2 = {0,1,0,-1};
    static int[] dy2 = {1,0,-1,0};
    static class Node{
        int x;
        int y ;
        int num;
        public Node(int x, int y,int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        graph = new int[R][C];
        queue = new ArrayDeque<>();
        airCleaner = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == -1) airCleaner.add(i);
                if(graph[i][j] >=5) queue.add(new Node(i,j,graph[i][j]));
            }
        }

        for (int i = 0; i < T; i++) {
            tempArr = new int[R][C];
            // 미세먼지 확산
            bfs();
//            for (int j = 0; j < R; j++) {
//                System.out.println(Arrays.toString(graph[j]));
//            }
            //System.out.println();
            // 공기청정기 작동
            cleaning(0,0,0);
            cleaning2(airCleaner.get(1),0,1);
//            for (int j = 0; j < R; j++) {
//                System.out.println(Arrays.toString(graph[j]));
//            }
//            System.out.println();
            // 미세먼지 다시 큐에 넣음
            addQueue();

        }
        int ans = sumFineDust();
        System.out.println(ans);


    }
    // 5 이상인 미세먼지 큐에 넣는 함수
    static void addQueue(){
        queue.clear();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(graph[i][j] >=5) queue.add(new Node(i,j,graph[i][j]));
            }
        }
    }

    // 미세먼지 확산 함수(bfs) - 1초마다 한번만 진행
    static void bfs(){
        while(!queue.isEmpty()){
            Node n = queue.poll();
            int cnt = 0; // 확산 방향 개수
            for (int i = 0; i < 4; i++) {
                int xi = n.x + dx[i];
                int yi = n.y + dy[i];
                if(xi < 0 || xi >= R || yi < 0 || yi >= C || graph[xi][yi] == -1) continue;
                graph[xi][yi] += (n.num /5);
                cnt ++;
            }
            graph[n.x][n.y] -= (n.num /5) * cnt;
        }
    }

    // 공기 청정기 작동 함수 - 위쪽 반시계 방향
    static void cleaning(int sx,int sy,int j){
        int d = 0;
        int xi = sx;
        int yi = sy;
        while(d < 4){
            if(xi == 0 && yi ==1) {
                tempArr[xi+dx[d]][yi+dy[d]] = graph[xi][yi];
                break;
            }
            if((xi+dx[d] < sx ) || (xi+dx[d] >= airCleaner.get(j)+1) || (yi+dy[d] < sy ) || (yi+dy[d] >= C)){
                d++;
            }
            if(graph[xi][yi] != -1) {
                tempArr[xi+dx[d]][yi+dy[d]] = graph[xi][yi];
            }else{
                tempArr[xi+dx[d]][yi+dy[d]] = 0;
            }
            xi = xi + dx[d];
            yi += dy[d];

        }
        tempArr[airCleaner.get(j)][0] = -1;

        for (int i = 1; i < airCleaner.get(j); i++) {
            for (int k = 1; k < C-1; k++) {
                tempArr[i][k] = graph[i][k];
            }
        }
    }

    // 공기 청정기 작동 함수 - 아래쪽 시계 방향
    static void cleaning2(int sx,int sy,int j){
        int d = 0;
        int xi = sx;
        int yi = sy;
        while(d < 4){
            if((xi+dx2[d] < sx ) || (xi+dx2[d] >= R) || (yi+dy2[d] < sy ) || (yi+dy2[d] >= C)){
                d++;
                if(d==4) break;
            }
            if(graph[xi][yi] != -1) {
                tempArr[xi+dx2[d]][yi+dy2[d]] = graph[xi][yi];
            }else{
                tempArr[xi+dx[d]][yi+dy[d]] = 0;
            }
            xi = xi + dx2[d];
            yi += dy2[d];

            if(xi == airCleaner.get(j)-1 && yi ==0) break;
        }
        tempArr[airCleaner.get(j)][0] = -1;

        for (int i = airCleaner.get(j)+1; i < R-1; i++) {
            for (int k = 1; k < C-1; k++) {
                tempArr[i][k] = graph[i][k];
            }
        }
        graph = tempArr;
    }

    // 미세먼지 양 계산 함수
    static int sumFineDust(){
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(graph[i][j] == -1 ) continue;
                sum += graph[i][j];
            }
        }
        return sum;
    }
}
