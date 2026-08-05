import java.util.*;
class Solution {
    int solution(int[][] land) {
        int answer = 0;

        for(int i=1;i<land.length;i++){
            for(int j=0;j<4;j++){
                int maxNum = 0;
                for(int k=0;k<4;k++){
                    if(j==k) continue;
                    maxNum = Math.max(land[i-1][k],maxNum);
                }
                land[i][j] += maxNum;
            }
        }
        
        for(int i=0;i<4;i++){
            answer = Math.max(answer,land[land.length-1][i]);
        }
        
        return answer;
    }
}