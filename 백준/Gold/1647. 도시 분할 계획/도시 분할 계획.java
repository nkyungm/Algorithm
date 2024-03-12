import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] parents; // 부모 노드 저장 배열
    static Edge[] edgeList; // 연결 저장 배열
    static boolean[] isSelected;
    static class Edge implements Comparable<Edge>{
        int from,to,weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        // 오름차순 정렬
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N+1];
        edgeList = new Edge[M];
        isSelected = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edgeList[i] = new Edge(from,to,weight);
        }

        // 오름차순 정렬
        Arrays.sort(edgeList);

        // 크기가 1인 서로소 집합 생성(초기화)
        makeSet();

        // 정렬된 간선 하나씩 꺼내면서 신장트리 만들기
        int weight = 0;
        int cnt =0;

        // 맨 처음 선택하는 edge의 부모 노드 저장

        for(Edge edge : edgeList){
            if(!union(edge.from,edge.to)) continue; //사이클 발생
            if(cnt == N-2) break;
            weight+=edge.weight;
            ++cnt;
            if(cnt==N-1) break; // 최소 신장트리 완성
            isSelected[edge.from] = isSelected[edge.to] = true;
        }
        System.out.println(weight);
    }
    static void makeSet(){
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }
    }

    // x가 속한 집합 대표자 찾기
    static int findSet(int x){
        if(x == parents[x]) return x; // 자기자신이 대표자
        return parents[x] = findSet(parents[x]); // 경로 압축
    }

    // a와 b 연결하기
    static boolean union(int a,int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if(aRoot == bRoot) return false; //a,b는 이미 같은 트리임(연결시, 사이클 발생)

        parents[bRoot] = aRoot;
        return true;
    }
}
