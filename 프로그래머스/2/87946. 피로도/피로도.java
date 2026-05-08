import java.util.*;
import java.io.*;

class Solution {
    static boolean[] visited;
    static int answer;
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        // 최소 피로도, 소모 피로도
        // 완탐 백트래킹 DFS
        visited = new boolean[dungeons.length];
        
        DFS(k,0,dungeons);
        
        return answer;
    }
    // 던전 위치, 현재 피로도, 탐험 개수
    private static void DFS(int k,int cnt,int[][] dungeons){
        answer = Math.max(answer,cnt);
        
        for(int i=0;i<dungeons.length;i++){
            // 방문하지 않았고 피로도가 가능하면
            if(!visited[i] && dungeons[i][0] <= k){
                visited[i] = true;
                DFS(k-dungeons[i][1],cnt+1,dungeons);
                visited[i] = false;
            }
        }
    }
}