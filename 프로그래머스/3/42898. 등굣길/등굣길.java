import java.util.*;

// 알고리즘 : DP
/*
1. 2차원배원 2중 for문 돌림
2. 만약, 위, 왼쪽에 숫자가 있다면 더해주기
3. 웅덩이는 미리 -1으로 고정
*/

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] arr = new int[n+1][m+1];
        int pSize = puddles.length;

        for(int i=0;i<pSize;i++){
            arr[puddles[i][1]][puddles[i][0]] = -1;
        }
        arr[1][1] = 1;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                int sum = 0;
                // 물웅덩이인 경우
                if(arr[i][j] == -1) continue;
            
                if (arr[i-1][j] != -1) sum += arr[i-1][j];
                if (arr[i][j-1] != -1) sum += arr[i][j-1];
                
                if(sum >0)arr[i][j] = sum%1000000007;
            }
        }
        answer = arr[n][m];
        
        return answer;
    }
}