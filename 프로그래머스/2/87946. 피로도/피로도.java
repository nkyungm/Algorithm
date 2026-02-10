import java.util.*;
class Solution {
    boolean[] visited;
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        // lcs (x) : 길이 정해져 있음
        // 비트마스크 dp, dfs
        
        visited = new boolean[dungeons.length];
        dfs(k,dungeons,0);
        
        return answer;
    }
    // 현재 피로도, 탐험한 개수
    private void dfs(int k, int[][] dungeons, int cnt){
        answer = Math.max(cnt,answer);
        
        for(int i=0;i<dungeons.length;i++){
            if(!visited[i] && k>= dungeons[i][0] ){
                // k-=dungeons[i][1]; // 피로도 감소
                visited[i] = true;
                dfs(k-dungeons[i][1],dungeons,cnt+1);
                visited[i] = false;
            }
        }
    }
}