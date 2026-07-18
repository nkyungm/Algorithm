import java.util.*;
class Solution {
    static boolean[] visited;
    static List<ArrayList<Integer>> graph;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        visited = new boolean[n];
        // 2차원 list
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        // 간선 리스트 채우기
        for(int i=0;i<edge.length;i++){
            int from = edge[i][0]-1;
            int to = edge[i][1]-1;
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        answer = BFS(n, 0);
        
        // BFS로 1부터 시작
        // depth 체크하면서 max일때 갱신
        
        return answer;
    }
    static int BFS(int n,int node){
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{node,0});
        visited[node] = true;
        
        // max depth값이랑 개수 초기화
        int maxDepth = 0;
        int cnt = 0;
        
        while(!queue.isEmpty()){
            int[] v = queue.poll();
            int vNode = v[0];
            int vDepth = v[1];
            // 최대값 체크
            if(vDepth > maxDepth){
                maxDepth = vDepth;
                cnt = 1;
            }else if(vDepth == maxDepth){
                cnt++;
            }
            
            // 연결값 체크
            for (int dv : graph.get(vNode)) {
                if(visited[dv]) continue;
                queue.add(new int[]{dv,vDepth+1});
                visited[dv] = true;
            }
        }

        return cnt;
    }
}