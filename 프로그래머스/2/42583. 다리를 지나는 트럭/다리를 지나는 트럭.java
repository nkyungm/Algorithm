import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        // 다리  = 큐
        Queue<Integer> queue = new ArrayDeque<>();
        int time = 0;
        int curWeight = 0;
        int idx = 0;
        
        for(int i=0;i<bridge_length;i++){
            queue.offer(0);
        }
        
        // 매초 마다 반복
        while(idx < truck_weights.length || curWeight > 0){
            // 시간 증가
            time++;
            // 다리에서 트럭 내리기
            curWeight-=queue.poll();
            // 다리에 올라갈 수있는지 확인
            if(idx < truck_weights.length
               && weight >= curWeight+truck_weights[idx]){
                queue.offer(truck_weights[idx]);
                curWeight += truck_weights[idx];
                idx++;
            }else{
                queue.offer(0);
            }
        }
        
        return time;
    }
}