import java.util.*;
class Solution {
    int solution(int[][] land) {
        int answer = 0;

        // 1 2 3 5
        // 5 6 7 8
        // 4 3 2 1 
        // 각 열마다 최대값 저장
        // dp[i][j] = dp[i][j] + max(dp[i-1][k]) (k!=j)
        int[][] dp = new int[land.length][4];
        dp[0][0] = land[0][0];
        dp[0][1] = land[0][1];
        dp[0][2] = land[0][2];
        dp[0][3] = land[0][3];
        for(int i=1;i<land.length;i++){
            for(int j=0;j<4;j++){
                int maxNum = 0;
                for(int k=0;k<4;k++){
                    if(j==k) continue;
                    maxNum = Math.max(maxNum,dp[i-1][k]);
                }
                dp[i][j] = land[i][j] + maxNum;
            }
        }
        
        for(int i=0;i<4;i++){
            answer = Math.max(answer,dp[land.length-1][i]);
        }
        
        return answer;
    }
}