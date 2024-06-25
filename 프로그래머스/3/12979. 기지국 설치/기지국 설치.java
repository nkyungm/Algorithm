import java.util.*;

// 알고리즘 : 
/*
- 최소 설치 : for문? 
- 뒤에서부터 시작하면 될듯 (뒤에 전달되지 않은 경우 무조건 설치)
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