import java.util.*;

// 1. for문돌리면서 1부터 n까지 차례대로 방문
// 2. bfs를 돌면서 방문처리
// 3. bfs 끝나면 cnt ++
// 4. visited 배열이 다 true가 될때까지 반복

class Solution {
    
    static boolean[] visited; // 방문처리 배열
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int num =0;
        visited = new boolean[n];
        
        while(num!=-1){
            bfs(num,n,computers);
            answer++;
            num = checkVisited(n);
        }
        
        return answer;
    }
    
    static void bfs(int num,int n,int[][] computers){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(num);
        visited[num] = true;
        
        while(!queue.isEmpty()){
            int v = queue.poll();
            for(int i=0;i<n;i++){
                if(computers[v][i]==0) continue;
                if(visited[i]) continue;
                queue.add(i);
                visited[i] = true;
            }
        }
    }
    
    // 전체 방문처리 여부 확인 함수
    static int checkVisited(int n){
        for(int i=0;i<n;i++){
            if(!visited[i]) return i;
        }
        return -1;
    }
}