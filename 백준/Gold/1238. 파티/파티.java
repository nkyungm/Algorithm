import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,X;
    static ArrayList<ArrayList<Node>> graph;
    static int[] D;
    static class Node implements Comparable<Node>{
        int x,cost;

        public Node(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }

        // cost 순 오름차순
        @Override
        public int compareTo(Node o) {
            return this.cost-o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(startNode).add(new Node(endNode,cost));
        }

        int MAX = 0;
        for (int i = 1; i <= N ; i++) {
            MAX = Math.max(MAX,Dijkstra(i,X)+Dijkstra(X,i));
        }
        System.out.println(MAX);

    }
    static int Dijkstra(int start,int end){
        D = new int[N+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(D,Integer.MAX_VALUE);
        D[start] = 0;
        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node n = pq.poll();

            if(n.x == end){
                return D[n.x];
            }

            if(n.cost > D[n.x]) continue;

            for (int i = 0; i < graph.get(n.x).size(); i++) {
                Node v = graph.get(n.x).get(i);
                if(n.cost + v.cost > D[v.x]) continue;

                D[v.x] = n.cost + v.cost;
                pq.add(new Node(v.x,D[v.x]));
            }
        }
        return D[end];
    }
}
