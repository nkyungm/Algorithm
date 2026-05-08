import java.util.*;
import java.io.*;

class Solution {
    // BFS
    // 0: 벽이 있는 자리, 1: 벽없는 자리
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        
        // BFS로 최소 거리 구하기
        answer = BFS(maps,n,m);
        
        return answer;
    }
    private static int BFS(int[][] maps,int n,int m){
        Deque<Robot> queue = new ArrayDeque<>();
        boolean[][] visited= new boolean[n][m];
        queue.add(new Robot(0,0,1));
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            Robot robot = queue.poll();
            if(robot.x == n-1 && robot.y == m-1){
                return robot.cnt;
            }
            
            for(int i=0;i<4;i++){
                int xi = dx[i] + robot.x;
                int yi = dy[i] + robot.y;
                if(xi < 0 || xi >=n || yi<0 || yi>=m) continue;
                if(!visited[xi][yi] && maps[xi][yi]==1){
                    visited[xi][yi] = true;
                    queue.add(new Robot(xi,yi,robot.cnt+1));
                }
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