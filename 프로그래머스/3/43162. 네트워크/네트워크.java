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
            DFS(i,n,computers);
            answer++;
        }
        
        return answer;
    }
    static void DFS(int v,int n,int[][] computers){
        // 종료 조건
        if(visited[v]) return;
        
        visited[v] = true;
        for(int i=0;i<n;i++){
            if(visited[i]) continue;
            if(computers[v][i] ==0) continue;
            DFS(i,n,computers);
        }
    }
}