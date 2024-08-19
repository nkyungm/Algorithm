import java.util.*;
import java.lang.*;

/*
- K칸 점프
- x2 순간이동 (슈트 착용 이동)
- 10억이기 때문에 bfs 안됨
- 단순 while문으로 구현 가능
*/
public class Solution {
    public int solution(int n) {
        int ans = 0;
        //dp top-down 방식 적용
        //최대한 많이 2로 나누고
        // 2로 나누어떨어지지 않으면 -1하기
        while(n!=0){
            if(n%2==0) n/=2;
            else{
                n--;
                ans++;
            }
        }
        return ans;
    }
}