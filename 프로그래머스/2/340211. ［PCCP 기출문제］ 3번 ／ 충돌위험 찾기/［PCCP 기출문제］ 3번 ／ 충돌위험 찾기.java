import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        // [시간][r][c]
        int maxTime = (routes[0].length - 1) * 198 + 1;
        int[][][] visited = new int[maxTime][101][101];
        
        // 1. routes 차례대로 구하기
        for(int i=0;i<routes.length;i++){
            int[] route = new int[routes[i].length];
            // 2. 루트 돌기
            int time = 0;
            int r= 0;
            int c= 0;
            for(int j=0;j<routes[i].length-1;j++){
                int startRoute = routes[i][j]-1;
                int endRoute = routes[i][j+1]-1;
                int[] startPoint = points[startRoute];
                int[] endPoint = points[endRoute];
                r = startPoint[0];
                c = startPoint[1];
                
                // 시작 지점 0초도 충돌지점으로 체크
                if(time ==0){
                    visited[time][r][c] +=1;
                    if(visited[time][r][c] ==2){
                        answer++;
                    }
                }
                
                // 3. end 도착할때 까지 최단거리 이동 + 시간별로 기록
                while(r != endPoint[0] || c != endPoint[1]){
                    
                    // 4. 좌표 이동
                    if(r != endPoint[0]){
                        if(r < endPoint[0]){
                            r +=1;
                        }else{
                            r-=1;
                        }
                    }else{
                        if( c < endPoint[1]){
                            c+=1;
                        }else{
                            c-=1;
                        }
                    }
                    time++;
                    visited[time][r][c] +=1;
                    if(visited[time][r][c] ==2){
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
}