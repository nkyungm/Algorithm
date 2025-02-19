import java.util.*;
class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        // 개수 계산 : BFS, DFS
        // 여기서 for문 돌리면서 계속 진행
        // 0~n-1까지 배열값이 1이고 방문하지 않았으면 bfs 진행
        for(int i=0;i<n;i++){
            // 다른 노드 for문 돌리면서 1이고 방문안했으면 진행
            if(visited[i]) continue;
            BFS(i,n,computers);
            answer++;
        }
        
        return answer;
    }
    static void BFS(int i,int n,int[][] computers){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(i);
        visited[i] = true;
        
        while(!queue.isEmpty()){
            int v = queue.poll();
            
            for(int j=0;j<n;j++){
                // for문 돌면서 방문했거나 0이면 continue;
                if(visited[j]) continue;
                if(computers[v][j] ==0) continue;
                visited[j] = true;
                queue.add(j);
            }
        }
    }
}