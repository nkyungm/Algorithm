import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] graph;
    static Node[] persons;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static List<ArrayList<Integer>> favorite;
    static class Node implements Comparable<Node>{
        // x좌표, y좌표, 좋아하는 학생 인접 개수, 비어있는 인접 칸 개수
        int x,y,cnt,blankCnt;
        public Node(int x, int y, int cnt, int blankCnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.blankCnt = blankCnt;
        }

        public Node(int x, int y,int blankCnt) {
            this.x = x;
            this.y = y;
            this.blankCnt = blankCnt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public int compareTo(Node o) {
            // 1. cnt 많은순부터 내림차순 정렬
            if(this.cnt == o.cnt){
                // 2. 인접 빈칸의 개수가 많은 순부터 내림차순 정렬
                if(this.blankCnt == o.blankCnt){
                    // 3. 행 기준 오름차순 정렬
                    if(this.x == o.x){
                        // 4. 열 기준 오름차순 정렬
                        return this.y - o.y;
                    }
                    return this.x - o.x;
                }
                return o.blankCnt - this.blankCnt;
            }
            return o.cnt - this.cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine()); //교실 크기
        graph = new int[N][N];
        // 학생들 좌표 저장 배열
        persons = new Node[N*N+1];
        Arrays.fill(persons,new Node(-1,-1,0,0));
        favorite = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < N*N+1; i++) {
            favorite.add(new ArrayList<>());
        }

        // 좋아하는 친구들 넣기
        for (int i = 0; i < N*N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++) {
                favorite.get(p).add(Integer.parseInt(st.nextToken()));
            }
            pickSeat(p);
        }

        System.out.println(satisfaction());

    }

    // 자리 정하기
    static void pickSeat(int p){
        // 우선순위큐 사용
        Queue<Node> pq = new PriorityQueue<>();
        List<Node> arr = new ArrayList<>();

        // 상하좌우 탐색하면서 노드 저장하기
        for (int i = 0; i < 4; i++) {
            int friend = favorite.get(p).get(i);
            // 현재 자리 앉아있지 않는 것임
            if(persons[friend].x == -1) continue;

            // 현재 자리에 있는 경우
            for (int j = 0; j < 4; j++) {
                int xi = persons[friend].x + dx[j];
                int yi = persons[friend].y + dy[j];

                if(xi < 0 || xi >= N || yi <0 || yi>=N) continue;
                // 자리 이미 있는 경우
                if(graph[xi][yi]> 0 ) continue;

                // 동일한 좌표가 이미 선택되어 있는지 체크
                // 이미 있으면 cnt+1만하고 넘어감
                if(arr.contains(new Node(xi,yi,0))){
                    int idx = arr.indexOf(new Node(xi,yi,0));
                    Node n = arr.get(idx);
                    arr.set(idx, new Node(n.x,n.y,n.cnt+1,n.blankCnt));
                    continue;
                }

                int blankCnt = 0;
                // 인접 빈칸 체크
                for (int k = 0; k < 4; k++) {
                    int xi2 = xi + dx[k];
                    int yi2 = yi + dy[k];
                    if(xi2 < 0 || xi2 >= N || yi2 <0 || yi2>=N) continue;
                    if(graph[xi2][yi2] ==0) blankCnt++;
                }
                // 배열에 노드 저장
                arr.add(new Node(xi,yi,blankCnt));
            }
        }

        // 배열에 해당되는 노드가 아무것도 없는 경우
        // 배열 모두 탐색하면서 0인 공간 사방탐색하면서 빈칸들 개수 세서 넣어주기
        if(arr.isEmpty()){
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(graph[i][j] > 0 )continue;
                    int blankCnt =0;
                    for (int k = 0; k <4 ; k++) {
                        int xi = i + dx[k];
                        int yi = j + dy[k];
                        if(xi < 0 || xi >= N || yi <0 || yi>=N) continue;
                        if(graph[xi][yi]== 0 ) blankCnt++;
                    }
                    pq.add(new Node(i,j,blankCnt));
                }
            }
        }else{ // 있는 경우
            for(Node n: arr){
                pq.add(n);
            }
        }
        // 최종적으로 앉을 좌표
        Node ansSeat = pq.poll();
        persons[p] = ansSeat; //좌표저장
        graph[ansSeat.x][ansSeat.y] = p; //자리 저장
    }
    // 만족도 구하기
    static int satisfaction(){
        int totalValue = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int p = graph[i][j];
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int xi = i + dx[k];
                    int yi = j + dy[k];
                    if(xi < 0 || xi >= N || yi <0 || yi>=N) continue;
                    if(favorite.get(p).contains(graph[xi][yi])) cnt++;
                }
                if(cnt == 1) totalValue +=1;
                else if(cnt == 2) totalValue+=10;
                else if(cnt == 3) totalValue+=100;
                else if(cnt ==4) totalValue+=1000;
            }
        }
        return totalValue;
    }
}
