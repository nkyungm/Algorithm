import java.util.*;
class Solution {
    static int[][] graph;
    static int[] dist;
    public int solution(int N, int[][] road, int K) {
        int answer = 1;
        graph = new int[N][N];
        dist = new int[N];
        
        for(int i=0;i<N;i++){
            dist[i] = 500001;
        }
        
        // 아니면 BFS에서 만족하지 않으면 방문체크 풀기..?
        // 다익스트라
        // 방문체크 어디서 풀기? : queue poll 시점
        // 실제 큐 넣을때 크기 안되면 아예 안넣으면 되자나
        
        for(int i=0;i<road.length;i++){
            int n1 = road[i][0]-1;
            int n2 = road[i][1]-1;
            int d = road[i][2];
            // 여러개 있는것은 작은거 넣기
            if(graph[n1][n2] > 0){
                graph[n1][n2] = Math.min(graph[n1][n2], d);
                graph[n2][n1] = Math.min(graph[n2][n1], d);
            }else if(graph[n1][n2] == 0) {
                graph[n1][n2] = d;
                graph[n2][n1] = d;
            }
        }
        
        BFS(N, K, 0);
        
        // 배달 가능 찾기
        for(int i=1;i<N;i++){
            if(dist[i] <= K) answer++;
        }
        
        return answer;
    }
    static void BFS(int N, int K, int start){
        Queue<Node> queue = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.sum,o2.sum));
        queue.add(new Node(start,0));
        
        while(!queue.isEmpty()){
            Node v = queue.poll();
            // 어차피 queue 넣을때 sum 체크(K에 맞는것만 넣을것임)
            
            int idx = v.idx;
            int sum = v.sum;
            
            for(int i=0;i<N;i++){
                int distance = graph[idx][i];
                // 조건 : 방문 여부, 연결되어있는지(0이상),K 안넘는지
                if(distance ==0) continue;
                if(distance + sum > K) continue;
                if(distance + sum < dist[i]){
                    queue.add(new Node(i,distance+sum));
                    dist[i] = distance + sum;
                }
            }
        }
        
    }
    static class Node{
        int idx;
        int sum;
        Node(int idx,int sum){
            this.idx = idx;
            this.sum = sum;
        }
    }
}