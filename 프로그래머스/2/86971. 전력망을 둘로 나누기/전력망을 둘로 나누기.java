import java.util.*;
class Solution {
    static boolean[][] arr;
    public int solution(int n, int[][] wires) {
        int answer = n;
        arr = new boolean[n+1][n+1];
        
        int wireLen = wires.length;
        
        for(int i=0;i<wireLen;i++){
            int[] wire = wires[i];
            arr[wire[0]][wire[1]] = arr[wire[1]][wire[0]]= true;
        }

        for(int i=0;i<wireLen;i++){
            // 1. for문 돌면서 간선 하나씩 제거
            int[] wire = wires[i];
            arr[wire[0]][wire[1]] = arr[wire[1]][wire[0]]= false;
            //2. bfs로 v1 기준으로 개수 체크
            int cnt = bfs(n,wire[0]);
            //3. 최소 차이값 갱신
            answer = Math.min(answer,Math.abs((n-cnt)-cnt));
            // 4. 간선 복구
            arr[wire[0]][wire[1]] = arr[wire[1]][wire[0]]= true;
        }
        
        
        return answer;
    }
    static int bfs(int n, int v){
        boolean[] visited = new boolean[n+1];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{v,1});
        visited[v] = true;
        int maxCnt = 1;
        
        while(!queue.isEmpty()){
            int[] dv = queue.poll();
            
            for(int i=1;i<=n;i++){
                if(arr[dv[0]][i] && !visited[i]){
                    visited[i] = true;
                    queue.add(new int[]{i,dv[1]+1});
                    maxCnt++;
                }
            }
        }
        return maxCnt;
    }
}