import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {0,0};
        int num = 0;
        while(!s.equals("1")){
            num = countZero(s);
            answer[0] ++;
            answer[1] += num;
            s = Integer.toBinaryString(s.length()-num);
        }
        
        return answer;
    }
    static int countZero(String s){
        int cnt =0;
        for(char c : s.toCharArray()){
            if(c == '0') cnt++;
        }
        return cnt;
    }
}