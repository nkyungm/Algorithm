import java.util.*;
// 중복안됨
class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=1;i<=n;i++){
            if(go(i,n)) answer++;
        }
        return answer;
    }
    static boolean go(int idx,int n){
        int sum =0;
        for(int i=idx;i<=n;i++){
            if(sum + i > n) return false;
            if(sum + i == n) return true;
            sum+= i;
        }
        return true;
    }

}
