import java.util.*;
import java.lang.*;

/*
DP 문제 푸는 방법
2.1. down-up(방정식)으로 푸는 방법
- [7], [10,15], [18,16,15],[20,25,20,19],[24,30,27,26,24]
- 자식노드랑 더할때 (자신의 인덱스, 자신의 인덱스+1)에 더하기
- 겹치는 부분은 더 큰것으로 갱신

2.2. dp 배열 없이 푸는 방법
- 자식 노드가 부모노드를 선택해 더해줘야함
    - 맨 앞이나 맨끝에 있는 경우 ) 그냥 부모 노드 더함
    - 그 외의 경우 ) 자신의 같은 위치의 부모노드와 인덱스-1 노드 중 더큰것 더해주기
*/

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        // 1. 반복문으로 돌리면서 값 갱신(메모이제이션)
        int tSize = triangle.length; // 삼각형의 깊이
        
        for(int i=1;i<tSize;i++){
            // 2. 맨앞이나 맨끝 인덱스는 부모 노드 바로 더해주기
            triangle[i][0] += triangle[i-1][0];
            triangle[i][i] += triangle[i-1][i-1];
            
            // 3. 그 외에는 j-1,j 중 큰 것 더해주기
            for(int j=1;j<i;j++){
                triangle[i][j] += Math.max(triangle[i-1][j-1],triangle[i-1][j]);
            }
        }
        
        // 3. 최댓값 구하기
        for(int i=0;i<tSize;i++){
            answer = Math.max(triangle[tSize-1][i],answer);
        }
        
        return answer;
    }
}