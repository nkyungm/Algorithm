import java.util.*;

class Solution {
    boolean[][] visited;
    int[] dx = new int[]{-1,1,0,0};
    int[] dy = new int[]{0,0,-1,1};
    int n;
    int m;
    public int solution(int[][] maps) {
        // BFS
        int answer = -1;
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        answer = BFS(maps,0,0);
        
        return answer;
    }
    int BFS(int[][] maps,int x,int y){
        Deque<Robot> queue= new ArrayDeque<>();
        queue.add(new Robot(x,y,1));
        visited[x][y] = true;
        
        while(!queue.isEmpty()){
            Robot r = queue.poll();
            
            // 상대 팀 진영(n-1,n-1)에 도착했는지 확인
            if(r.x == n-1 && r.y == m-1){
                return r.cnt;
            }
            
            for(int i=0;i<4;i++){
                int xi = dx[i] + r.x;
                int yi = dy[i] + r.y;
                // 벗어나는지 확인
                if(xi <0 || xi>=n || yi<0 || yi>=m) continue;
                // 벽으로 막혀있지 않은지, 방문했는지 확인
                if(visited[xi][yi] || maps[xi][yi] ==0) continue;
                queue.add(new Robot(xi,yi,r.cnt+1));
                visited[xi][yi] = true;
            }
        }
        
        return -1;
        
    }
    class Robot{
        int x;
        int y;
        int cnt;
        Robot(int x,int y,int cnt){
            this.x = x;
            this.y= y;
            this.cnt =cnt;
        }
    }
}