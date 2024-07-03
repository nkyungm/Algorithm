import java.util.*;
import java.lang.*;

// 알고리즘 : DP
/*
1. 스티커가 3개 이하인 경우 ) 3개중 가장 큰 것 선택
2. 스티카가 3개 초과인 경우 ) 0번째 고를 경우, 1번째 고를 경우 2가지 DP 처리
2.1. 0번째 스티커 고를 경우) 
2.2. 1번째 스티커 고를 경우)
*/

class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int size = sticker.length;
        
        if(size <=3) {
            for(int s: sticker) answer = Math.max(answer,s);
            return answer;
        }
        
        int[] dp = new int[size-3];
        int maxSum=0;
        
        // 0번째 선택했을 때 dp
        for(int i=2;i<size-1;i++){
            if(i<=3) dp[i-2] = sticker[i];
            else if(i==4) dp[i-2] = sticker[i] + dp[0];
            else dp[i-2] = sticker[i] + Math.max(dp[i-4],dp[i-5]);
            maxSum = Math.max(maxSum,dp[i-2]);
        }
        maxSum += sticker[0];
        answer = Math.max(maxSum,answer);
        
        maxSum = 0;
        // 1번째 선택했을 때 dp
        for(int i=3;i<size;i++){
            if(i<=4) dp[i-3] = sticker[i];
            else if(i==5) dp[i-3] = sticker[i] + dp[0];
            else dp[i-3] = sticker[i] + Math.max(dp[i-5],dp[i-6]);
            maxSum = Math.max(maxSum,dp[i-3]);
        }
        maxSum += sticker[1];
        answer = Math.max(maxSum,answer);
        
        maxSum = 0;
        // size-1번째 선택했을 때 dp
        for(int i=1;i<size-2;i++){
            if(i<=2) dp[i-1] = sticker[i];
            else if(i==3) dp[i-1] = sticker[i] + dp[0];
            else dp[i-1] = sticker[i] + Math.max(dp[i-3],dp[i-4]);
            maxSum = Math.max(maxSum,dp[i-1]);
        }
        maxSum += sticker[size-1];
        answer = Math.max(maxSum,answer);
        
        return answer;
    }
    
}