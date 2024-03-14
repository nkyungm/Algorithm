import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int V,E;
    static Edge[] edgeList;
    static int[] parent;
    static class Edge implements Comparable<Edge>{
        int from,to,weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        // 가중치 기준으로 오름차순
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edgeList = new Edge[E];
        for (int i = 0; i < E; i++) {
            st=  new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList[i] = new Edge(from,to,weight);
        }

        // make-set
        makeSet();

        // 가중치순으로 오름차순 정렬
        Arrays.sort(edgeList);

        // 신장트리 구하기(크루스칼 알고리즘)
        int totalWeight = 0;
        int cnt =0;
        for (int i = 0; i < E; i++) {
            Edge e = edgeList[i];
            if(!union(e.from,e.to)) continue;
            totalWeight += e.weight;
            if(++cnt == V-1) break;
        }
        System.out.println(totalWeight);
    }
    static void makeSet(){
        parent = new int[V+1];
        for (int i = 0; i < V+1; i++) {
            parent[i] =i;
        }
    }
    static int findSet(int a){
        if(a == parent[a]) return a;
        return parent[a] = findSet(parent[a]);
    }

    static boolean union(int a,int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) return false;

        parent[bRoot] = aRoot;
        return true;
    }
}
