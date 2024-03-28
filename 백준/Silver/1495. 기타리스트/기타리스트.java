import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,S,M;
    static int[] V;
    static int[] dp;
    static class Node implements Comparable<Node> {
        int x,idx;

        public Node(int x, int idx) {
            this.x = x;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o) {
            if(this.idx == o.idx){
            	return o.x - this.x;
            }
            return this.idx - o.idx;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", idx=" + idx +
                    '}';
        }
    }
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        V = new int[N];
        dp = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            V[i] = Integer.parseInt(st.nextToken());
        }
        BFS();
	}
	
	
	static void BFS(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[1001][1001];
        pq.add(new Node(S,0));
        visited[S][0] = true;

        while(!pq.isEmpty()){
            Node n = pq.poll();

            if(n.idx == N){
                System.out.println(n.x);
                return;
            }

            if(n.x + V[n.idx] >= 0 && n.x + V[n.idx] <= M && !visited[n.x + V[n.idx]][n.idx]) {
                pq.add(new Node(n.x + V[n.idx],n.idx+1));
                visited[n.x + V[n.idx]][n.idx] = true;
            }

            if(n.x - V[n.idx] >= 0 && n.x - V[n.idx] <= M && !visited[n.x - V[n.idx]][n.idx]){
                pq.add(new Node(n.x - V[n.idx],n.idx+1));
                visited[n.x - V[n.idx]][n.idx] = true;
            }
        }
       System.out.println(-1);
    }
}
