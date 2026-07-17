import java.util.*;

class Solution {
    static int ans=0;
    public int solution(int[] numbers, int target) {
        
        // 그래프 완탐 (DFS)
        // DFS 함수 안에서 +,-로 둘다 넣기
        // 종료조건(순서가 n일때 , target과 같으면 ans++)
        int n = numbers.length;
        DFS(numbers,n,target,-1,0);
        
        return ans;
    }
    static void DFS(int[] numbers, int n,int target, int cur,int sum){
        // 종료조건(순서가 n일때 , target과 같으면 ans++)
        if(cur == n-1){
            if(target == sum) ans++;
            return;
        }
        
        // 재귀 조건
        DFS(numbers,n,target,cur+1,sum+numbers[cur+1]);
        DFS(numbers,n,target,cur+1,sum-numbers[cur+1]);
    }
}