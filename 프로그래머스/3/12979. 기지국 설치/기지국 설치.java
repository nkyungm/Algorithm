import java.util.*;

// 알고리즘 : 구현
/*
- 최소 설치 : for문
- station이용해서 빈곳 크기만큼 개수 채워주기
*/

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int minIdx = 1;
        for(int station : stations){
            if(station-w > minIdx){
                int diff = (station-w)-minIdx;
                if(diff%(w*2+1)==0) answer+= diff/(w*2+1);
                else answer += (diff/(w*2+1)+1);
            }
            minIdx = station+w+1;
        }
        
        if(n >= minIdx){
            int diff = n+1-minIdx;
            if(diff%(w*2+1)==0) answer+= diff/(w*2+1);
            else answer += (diff/(w*2+1)+1);
        }
    
        return answer;
    }
}