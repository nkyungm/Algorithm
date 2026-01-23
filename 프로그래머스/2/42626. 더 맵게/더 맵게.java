import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a - b);
        
        for(int i : scoville) pq.offer(i);
        
        while(!pq.isEmpty() && pq.size() >= 2){
            // 꺼냈을때 K이상이면 종료
            if(pq.peek() >= K) return answer;
            
            // 가장 작은 + (두번쨰 작은 *2) 해서 다시 넣기
            int min1 = pq.poll();
            int min2 = pq.poll();
            
            pq.offer(min1 + min2 * 2);
            
            // 횟수 증가
            answer++;
        }
        
        // K 안넘으면 -1
        if(pq.peek() < K) answer = -1;
        
        return answer;
    }
}