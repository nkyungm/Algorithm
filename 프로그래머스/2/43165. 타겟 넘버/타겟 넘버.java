import java.util.*;

/**
BFS로 -,+ 둘다 넣어서 구현
*/


class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = bfs(numbers,target);
        return answer;
    }
    static int bfs(int[] numbers,int target){
        Queue<int[]> queue = new ArrayDeque<>();
        int L = numbers.length;
        boolean[] visited= new boolean[L];
        int cnt=0;
        queue.add(new int[]{0,numbers[0]});
        queue.add(new int[]{0,-numbers[0]});
        
        while(!queue.isEmpty()){
            int[] nArr = queue.poll();
            // 정답조건
            
            if(nArr[0]==L-1){
                if(nArr[1]==target) cnt++;
                continue;
            }
            
            // + 인 경우
            queue.add(new int[]{nArr[0]+1,nArr[1]+numbers[nArr[0]+1]});
            // -인 경우
            queue.add(new int[]{nArr[0]+1,nArr[1]-numbers[nArr[0]+1]});
            
        }
        return cnt;
    }
}