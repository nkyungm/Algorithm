import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        int cnt = count_one(n);
        for(int i=n+1;i<=1000000;i++){
            if(cnt == count_one(i)) return i;
        }        
        return answer;
    }
    // 이항 비트 연산을 이용한 log(n) 연산
    static int count_one(int n){
        int cnt = 0;
        while(n > 0){
            n &= n-1;
            cnt++;
        }
        return cnt;
    }
}