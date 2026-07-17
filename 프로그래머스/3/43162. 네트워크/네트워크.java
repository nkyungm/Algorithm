import java.util.*;

class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        // for문 돌아가면서 방문하지 않았으면 DFS 
        for(int i=0;i<n;i++){
            if(visited[i]) continue;
            DFS(n,computers,i);
            answer++;
        }
        
        return answer;
    }
    static void DFS(int n, int[][] computers, int cp){
        visited[cp] = true;
        
        // 반복 재귀
        for(int i=0;i<n;i++){
            if(cp == i || computers[cp][i] ==0) continue;
            if(visited[i]) continue;
            DFS(n,computers,i);
        }
    }
}