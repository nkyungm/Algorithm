import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //BFS
    //.: 땅, X: 빙하, L: 사람있는 공간
    static int R,C;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static Node[] swans;
    static Queue<Node> queueICE = new ArrayDeque<>();
    static Queue<Node> queueSwan = new ArrayDeque<>();

    static class Node{
        int x, y;

        public Node(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];
        swans = new Node[2];
        int idx =0;

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = s.charAt(j);
                if(graph[i][j] =='L') {
                    swans[idx] = new Node(i,j);
                    graph[i][j] = '.'; //물으로 만들어주기
                    idx++;
                }
                // 백조의 좌표도 물에 들어가야함!
                if(graph[i][j] == '.') queueICE.add(new Node(i,j));
            }
        }

        visited = new boolean[R][C];
        // 출발점의 백조 큐에 넣어주기
        queueSwan.add(swans[0]);
        visited[swans[0].x][swans[0].y] = true;

        int count = 0;
        while(true) {
            if(BFS_Swan()) break;
            BFS_ICE();
            count++;
        }
        System.out.println(count);

    }

    // 얼음 녹이기 BFS
    // 1. 물의 위치를 담은 큐는 입력 데이터때 따로 담아준다.
    // 2. 얼음을 녹일 때마다 현재 위치에 담긴 물을 모두 소진하여 인접한 얼음을 녹여주고,
    //    다음 싸이클에 녹을 얼음의 위치를 새롭게 큐에 담아준다.
    static void BFS_ICE() {
        int size = queueICE.size();
        for (int i = 0; i < size; i++) {
            Node n = queueICE.poll();
            for (int j = 0; j < 4; j++) {
                int xi = n.x + dx[j];
                int yi = n.y + dy[j];
                if(xi <0 || xi >=R || yi<0 || yi>=C) continue;
                if(graph[xi][yi] == '.') continue;

                graph[xi][yi] = '.';
                // 새로운 물 위치 갱신
                queueICE.add(new Node(xi,yi));
            }
        }
    }

    // 두 백조가 만날 수 있는지 확인 BFS
    // 1. 출발점의 백조(sx,sy)가 이동하면 얼음이 맞닿아 있는 직전 위치를 이동시켜준다.
    // 2. 따라서 다음 탐색에서는 (sx,sy)가 아닌 다음에 녹을 얼음이 맞닿아 있는 지점을 큐에 담아준다.
    static boolean BFS_Swan() {
        Queue<Node> queue = new ArrayDeque<>();

        while(!queueSwan.isEmpty()) {
            Node v= queueSwan.poll();

            // 도착점 백조에 온 경우 리턴
            if(v.x == swans[1].x && v.y == swans[1].y) return true;

            for (int i = 0; i < 4; i++) {
                int xi = v.x + dx[i];
                int yi = v.y + dy[i];

                if(xi<0 || xi >= R || yi <0 || yi >=C) continue;
                if(visited[xi][yi]) continue;

                visited[xi][yi] = true;
                // 물인 경우 큐에 담아주기
                if(graph[xi][yi] =='.') queueSwan.add(new Node(xi,yi));
                // 얼음인 경우, 다음 탐색지역 새로운 큐에 담아주기
                else if(graph[xi][yi] =='X') queue.add(new Node(xi,yi));
            }
        }
        //얼음과 맞닿아 있는 지점이 들어있는 큐로 갱신
        queueSwan = queue;
        return false;
    }
}