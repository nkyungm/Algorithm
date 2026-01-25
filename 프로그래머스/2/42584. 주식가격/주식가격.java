import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        // 뒤에서 가격이 깨지는 순간 
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<prices.length;i++){
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                int cur = stack.pop();
                answer[cur] = i - cur;
            }
            stack.push(i);
        }
        
        // 스택 남은거 처리
        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = prices.length - 1 - idx;
        }

        //
        // 0 1 2 3 4 ->      0
        
        return answer;
    }
}