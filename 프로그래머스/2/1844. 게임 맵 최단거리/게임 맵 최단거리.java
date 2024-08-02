import java.util.*;

/**
BFS 최단거리
*/

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    static Queue<Robot> queue = new ArrayDeque<>();
    static boolean[][] visited;
    static int M,N;
    public int solution(int[][] maps) {
        int answer = 0;
        M = maps[0].length;
        N = maps.length;
        visited = new boolean[N][M];
        queue.add(new Robot(0,0,1));
        visited[0][0] = true;
        answer = bfs(maps);
        return answer;
    }
    static int bfs(int[][] maps){
        while(!queue.isEmpty()){
            Robot r = queue.poll();
            if(r.x == N-1 && r.y == M-1) return r.cnt;
            
            for(int i=0;i<4;i++){
                int xi = r.x + dx[i];
                int yi = r.y + dy[i];
                if(xi <0 || xi>=N || yi<0 || yi>=M) continue;
                if(maps[xi][yi]==0 || visited[xi][yi]) continue;
                
                queue.add(new Robot(xi,yi,r.cnt+1));
                visited[xi][yi] = true;
            }
        }
        return -1;
    }
    
    static class Robot{
        int x;
        int y;
        int cnt;
        Robot(int x,int y,int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}