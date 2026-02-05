import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // y 6*4 
        // b (y가로+2)*2 + (y세로*2)
        for(int i=1;i<=(int)Math.sqrt(yellow);i++){
            if(yellow%i != 0) continue;
            answer[0] = yellow/i;
            answer[1] = i;
            
            int yellow_cnt = (answer[0]+2)*2 + answer[1]*2;
            if(yellow_cnt == brown){
                answer[0]+=2;
                answer[1]+=2;
                return answer;
            }
        }
        
        // return 가로 +2, 세로+2
        
        return answer;
    }
}