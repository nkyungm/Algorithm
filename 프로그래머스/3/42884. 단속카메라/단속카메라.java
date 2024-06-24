import java.util.*;
import java.lang.*;

// 알고리즘 : 탐욕법
/*
1. 첫번째 원소 기준으로 오름차순 정렬
2. 두번째 값 저장하고 가장 큰값이랑 비교 갱신
*/

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        int routesSize = routes.length;

        // 주의) 2차원 정렬시 Comparator따로 사용해야함
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        
        int maxValue = routes[0][1];
        for(int i=1;i<routesSize;i++){
            if(maxValue >= routes[i][0]) continue;
            answer++;
            maxValue = routes[i][1];
        }
        return answer;
    }
}