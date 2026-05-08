import java.util.*;

class Solution {
    static boolean[][] arr;
    static boolean[] visited;
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        // 인접 노드 저장
        arr = new boolean[n+1][n+1];
        visited = new boolean[n+1];

        for(int i=0;i<wires.length;i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            arr[v1][v2] = arr[v2][v1] = true;
        }
        
        for(int i=0;i<n-1;i++){
            // 해당 전선 끊기
            int x1 = wires[i][0];
            int x2 = wires[i][1];
            arr[x1][x2] = false;
            arr[x2][x1] = false;
            
            // BFS로 두개 노드 사이 개수 비교
            answer = Math.min(answer,Math.abs(DFS(x1,n,wires)-DFS(x2,n,wires)));
                
            arr[x1][x2] = true;
            arr[x2][x1] = true;
            visited = new boolean[n+1];
            
            
        }
        
        return answer;
    }
    private static int DFS(int v,int n,int[][] wires){
        visited[v] = true;
        int cnt = 1;
        
        for(int i=1;i<=n;i++){
            if(!visited[i] && arr[v][i]){
                cnt += DFS(i,n,wires); // 계속 노드 개수 더해짐
            }
        }
        
        return cnt;
    }
}