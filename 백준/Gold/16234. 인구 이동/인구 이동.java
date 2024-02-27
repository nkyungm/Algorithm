// NxN 땅, 땅에는 나라가 하나씩 존재, 인접한 나라 사이에 국경선 존재
// 인구 이동은 하루동안 진행, 인구 이동이 없을 때까지 지속

// 인구 이동 규칙
// 1. 국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하 -> 두 나라가 공유하는 국경선을 하루동안 연다.
// 2. 위의 조건에 의해 열어야하는 국경선 모두 열리면, 인구 이동 시작
// 3. 국경선이 열려있어 인접한 칸만을 이용해 이동 가능 -> 그 나라를 연합이라고 함
// 4. 연합을 이루고 있는 각 칸의 인구수 = (연합의 인구수)/(연합 이루고 있는 칸 개수) , 소수점 버림
// 5. 연합 해체 -> 모든 국경선 닫는다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 인구 이동 며칠 동안 발생하는지 구하기
public class Main {
    static int N,L,R;
    static int[][] graph;
    static boolean[][] visited;
    static List<Node> arr;
    static List<Integer> arr2;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    static class Node{
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        // 처음 (0,0) 나라부터 국경선 공유하는지 아닌지 확인
        boolean closeCheck = false;
        while(!closeCheck){
            cnt++;
            closeCheck = true;
            visited = new boolean[N][N]; // 방문처리
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) continue;
                    arr = new ArrayList<>();
                    DFS(new Node(i, j));

                    // arr.size() > 1 일때만 인구이동
                    if (arr.size() == 1) continue;

                    closeCheck = false;
                    int personTotal = 0;
                    for (int k = 0; k < arr.size(); k++) {
                        personTotal += graph[arr.get(k).x][arr.get(k).y];
                    }
                    int num = personTotal / arr.size();

                    for (int k = 0; k < arr.size(); k++) {
                        graph[arr.get(k).x][arr.get(k).y] = num;
                    }
                }
            }
        }

        if(cnt > 0) cnt--;
        System.out.println(cnt);

    }
    // DFS로 사방탐색 진행하면서 연합 찾기
    // 1. 국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하 -> 두 나라가 공유하는 국경선을 하루동안 연다.
    // 3. 국경선이 열려있어 인접한 칸만을 이용해 이동 가능 -> 그 나라를 연합이라고 함
    // 4. 연합을 이루고 있는 각 칸의 인구수 = (연합의 인구수)/(연합 이루고 있는 칸 개수) , 소수점 버림
    static void DFS(Node n){
        visited[n.x][n.y] = true;
        arr.add(new Node(n.x,n.y));

        for (int i = 0; i < 4; i++) {
            int xi = n.x + dx[i];
            int yi = n.y + dy[i];

            if(xi <0 || xi>=N || yi <0 || yi>=N) continue;
            if(visited[xi][yi]) continue;
            int diff = Math.abs(graph[n.x][n.y]-graph[xi][yi]);
            if(diff < L || diff > R) continue; //인구차이 체크

            DFS(new Node(xi,yi));
        }
    }
}
