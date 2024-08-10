import java.util.*;

class Solution {
    static int[] dp;
    public int solution(int n) {
        int answer = 0;
        dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = (dp[i-1] + dp[i-2])%1234567;
        }
        answer = dp[n];
        return answer;
    }
    // 피보나치 수열(dp)
    // static long fibo(int n){
    //     if(n < 2) return n;
    //     return 
    // }
}