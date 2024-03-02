import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
class Solution
{
	static int N,M,K;
    static int[][] map;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static Queue<Node> pq = new PriorityQueue<>();
    static class Node implements Comparable<Node>{
        int x,y,X,cnt,state,time;

        // state : -1(죽음), 0(비활성화), 1(활성화)
        public Node(int x, int y, int x1, int cnt, int state, int time) {
            this.x = x;
            this.y = y;
            X = x1;
            this.cnt = cnt;
            this.state = state;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            if(this.time == o.time){
                return o.X - this.X;
            }
            return this.time - o.time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            pq = new PriorityQueue<>();

            map = new int[2*K+N][2*K+M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[K+i][K+j] = Integer.parseInt(st.nextToken());
                    if(map[K+i][K+j] ==0) continue;
                    pq.add(new Node(K+i,K+j,map[K+i][K+j],map[K+i][K+j],0,0));
                }
            }
            System.out.println("#"+(t+1)+" " +BFS());
        }
    }
    static int BFS(){

        while(!pq.isEmpty()){
            if(pq.peek().time == K) break;
            Node n = pq.poll();
            //n이 비활성화일 경우
            if(n.state == 0) {
                // 활성화로 변경되는 시점 ) 다시 cnt = n.X로 해서 활성화 시간 체크해줌
                if(n.cnt-1 == 0) pq.add(new Node(n.x,n.y,n.X,n.X,1,n.time+1));
                else pq.add(new Node(n.x,n.y,n.X,n.cnt-1,n.state,n.time+1));
            }else if(n.state == 1) { // n이 활성화일 경우
                for (int i = 0; i < 4; i++) {
                    int xi = n.x + dx[i];
                    int yi = n.y + dy[i];
                    if (map[xi][yi] > 0) continue;
                    map[xi][yi] = n.X;
                    // 비활성화 상태로 퍼짐
                    pq.add(new Node(xi, yi, n.X, n.X, 0, n.time + 1));
                }
                // 죽은 상태!
                if (n.cnt - 1 == 0) continue;
                else pq.add(new Node(n.x, n.y, n.X, n.cnt - 1, 1, n.time + 1));
            }
        }
        return pq.size();
    }
}