import java.io.*;
import java.util.*;
class Solution {
    static int ans = 0;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        // bfs 
        // 개수 체크 : bfs 처음 들어갈때 체크
        // bfs를 n번 들어가면서 boolean으로 이미 true면 pass
        
        visited = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(visited[i]) continue;
            BFS(n,computers,i);
            ans++;
        }
        
        return ans;
    }
    static void BFS(int n, int[][] computers, int cp){
        Deque<Integer> queue= new ArrayDeque<>();
        queue.add(cp);
        visited[cp] = true;
        
        while(!queue.isEmpty()){
            int v = queue.poll();
            // 해당 연결된 부분 돌아가면서 큐 삽입
            for(int i=0;i<n;i++){
                if(v==i || computers[v][i] == 0) continue;
                if(visited[i]) continue;
                queue.add(i);
                visited[i] = true;
            }
        }
    }
}