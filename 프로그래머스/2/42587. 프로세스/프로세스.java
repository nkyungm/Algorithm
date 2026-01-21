import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Process> queue = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> b - a);
        
        for(int i=0;i<priorities.length;i++){
            pq.offer(priorities[i]);
            queue.offer(new Process(i,priorities[i]));
        }
        
        // A -> A 넣고 B
        int i=0;
        while(!queue.isEmpty()){
            Process pro = queue.poll();
            // 우선순위 큐에는 우선순위만 담아 나와야하는 우선순위 확인
            if(pro.priority < pq.peek()){
                queue.add(pro);
            }else{
                pq.poll();
                i++;
                if(pro.idx == location) return i;
            }
        }
        return i;
    }
}

class Process{
    int idx;
    int priority;
    
    Process(int idx, int priority){
        this.idx = idx;
        this.priority = priority;
    }
}