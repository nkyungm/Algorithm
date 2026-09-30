import java.util.*;
class Solution {
    static int[] distance;
    static List<Node>[] graph;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        graph = new ArrayList[N+1];
        
        for(int i=0;i<=N;i++){
            graph[i] = new ArrayList<>();
        }
        
        // 2. graph안에 road 넣기
        for(int i=0;i<road.length;i++){
            int[] r = road[i];
            graph[r[0]].add(new Node(r[1],r[2]));
            graph[r[1]].add(new Node(r[0],r[2]));
        }
        
        go(N);
        for(int i=1;i<=N;i++){
            if(distance[i] <= K) answer++;
        }

        return answer;
    }
    static void go(int N){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{
            return o1.dis - o2.dis;
        });
        boolean[] visited = new boolean[N+1];
        distance = new int[N+1];
        // distance 값 무한대로 넣기
        Arrays.fill(distance,Integer.MAX_VALUE);
        
        //1.출발지 넣기
        pq.add(new Node(1,0));
        distance[1] = 0;

        while(!pq.isEmpty()){
            Node nd = pq.poll();
            // 2.큐에서 꺼냈을때 방문 처리
            // 방문처리(이미 방문 한 경우 넘기기)
            if(visited[nd.idx]) continue;
            visited[nd.idx] = true;

            // 3. 연결된 마을 pq에 넣기
            for(int i=0;i<graph[nd.idx].size();i++){
                Node toNd = graph[nd.idx].get(i);
                // 아직 방문하지 않은 경우에
                if(visited[toNd.idx]) continue;
                // 4. 거리 갱신
                if(distance[toNd.idx] > nd.dis + toNd.dis){
                    distance[toNd.idx] = nd.dis + toNd.dis;
                    pq.add(new Node(toNd.idx,nd.dis + toNd.dis));
                }
                
            }
        }
        
        
    }
    static class Node{
        int idx;
        int dis;
        
        public Node(int idx,int dis){
            this.idx = idx;
            this.dis =dis;
        }
    }
}