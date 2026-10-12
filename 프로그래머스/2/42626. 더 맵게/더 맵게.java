import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        // 종료 조건 
        // 모든 음식 K이상 못 만드는 경우 -> 스코빌 1개 < K => -1
        // 맨 앞 스코빌 >= K -> 종료 
        
        // pq 사용
        // pq 개수 1개면 종료
        // 1. 첫번째 꺼냈을때 스코빌 >=K 면 종료
        // 2. 아니면 1,2번째 꺼내서 계산하고 다시 넣기
        
        // 놓친 부분 : 정렬!!! => pq
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 1. 일단 pq에 다 넣기 (반대로)
        for(int i=scoville.length-1;i>=0;i--){
            pq.add(scoville[i]);
        }
        
        while(pq.size() >= 2){
            int food1 = pq.poll();
            int food2 = pq.poll();
            
            if(food1 >= K){
                return answer;
            }
            answer++;
            int mix = food1 + food2 *2;
            pq.add(mix);
        }
        
        int fn = pq.poll();
        if(fn < K){
            return -1;
        }
        
        return answer;
    }
}