import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> queue = new ArrayDeque<>();

        //100 - 30 = 70 /30 -> 2+1
        //100 -93 = 7/1 = 7
        //100 - 55 = 45/5 = 9

        for(int i=0;i<progresses.length;i++){
            int progress = progresses[i];
            int speed = speeds[i];
            
            int day = (100-progress)/speed;
            if((100-progress)%speed != 0 ) day++;
            
            queue.offer(day);
        }
        
        List<Integer> list = new ArrayList<>();
        
        while(!queue.isEmpty()){
            // 한개 잡아서 클때까지 계속 큐 돌리기
            int day = queue.poll();
            int cnt = 1;
            
            while(!queue.isEmpty() && day >= queue.peek()){
                cnt++;
                queue.poll();
            }
            list.add(cnt);
        }
        
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++) answer[i] = list.get(i);

        return answer;
    }
}