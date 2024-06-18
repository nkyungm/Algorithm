import java.util.*;

class Solution {
    // 우선순위 큐 적용
    static PriorityQueue<Integer> queueMin = new PriorityQueue<>();
    static PriorityQueue<Integer> queueMax = new PriorityQueue<>(Comparator.reverseOrder());
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        StringTokenizer st = null;
        for(String s:operations){
            st = new StringTokenizer(s);
            String command = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            go(command,num);
            
            // 답 넣기
            if(queueMax.isEmpty()) answer[0] = 0;
            else {
                answer[0] = queueMax.peek();
            }
            
            if(queueMin.isEmpty()) answer[1] = 0;
            else answer[1] = queueMin.peek();
            
        }
        
        return answer;
    }
    static void go(String command,int num){
        switch(command){
            case "I":
                queueMin.add(num);
                queueMax.add(num);
                break;
            case "D":
                if(queueMax.isEmpty() || queueMin.isEmpty()) break;
                if(num == 1){
                    int numMax = queueMax.peek();
                    queueMax.remove(numMax);
                    queueMin.remove(numMax);
                }else if(num == -1){
                    int numMin = queueMin.peek();
                    queueMax.remove(numMin);
                    queueMin.remove(numMin);
                }
                break;
        }
    }
}