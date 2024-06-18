import java.util.*;
// 알고리즘 : 구현
/*
1. s를 n으로 나눈 값을 저장
2. 그리고 n--
ex) 5,525 
*/

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {};
        if(n>s) return new int[]{-1};
        answer = new int[n];
        
        for(int i=n;i>0;i--){
            answer[n-i] = s/i;
            s -= answer[n-i];
        }
    
        return answer;
    }
}