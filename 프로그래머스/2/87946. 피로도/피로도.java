import java.util.*;
class Solution {
    static boolean[] visited;
    static int answer;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        int N = dungeons.length;
        visited = new boolean[N];
        
        go(k,dungeons,0);
        
        return answer;
    }
    static void go(int k, int[][] dungeons, int cnt){
        answer = Math.max(answer,cnt);
        
        for(int i=0;i<dungeons.length;i++){
            // 조건 : 방문하지 않았거나, 최소 필요 피로도가 k보다 작거나 같은 경우
            if(!visited[i] && k >= dungeons[i][0]){
                visited[i] = true;
                go(k-dungeons[i][1],dungeons,cnt+1);
                visited[i] = false;
            }
        }
    }
}