import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = BFS(maps);
        // 최소 거리 : BFS
        
        return answer;
    }
    
    static int[] dx = new int[]{0,0,1,-1};
    static int[] dy = new int[]{1,-1,0,0};
    static int BFS(int[][] maps){
        int n = maps.length;
        int m = maps[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        
        queue.add(new int[]{0,0,1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] v = queue.poll();
            
            // 종료 조건
            if(v[0] == n-1 && v[1] == m-1) return v[2];
            
            for(int i=0;i<4;i++){
                int xi = dx[i] + v[0];
                int yi = dy[i] + v[1];
                if(xi <0 || xi>=n || yi <0 || yi>=m) continue;
                if(visited[xi][yi]) continue;
                if(maps[xi][yi] ==0) continue;
                visited[xi][yi] = true;
                queue.add(new int[]{xi,yi,v[2]+1});
            }
        }
        
        return -1;
    }
}