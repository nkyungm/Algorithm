import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        // book_time을 시작 시간이 작은 순서대로 정렬
        // 분 형태로 변경
        int[][] time = new int[book_time.length][2];
        
        for(int i=0;i<book_time.length;i++){
            String[] bt = book_time[i];
            
            String[] startTm = bt[0].split(":");
            String[] endTm = bt[1].split(":");
            
            time[i][0] = calMinute(startTm);
            time[i][1] = calMinute(endTm);
        }
        
        // 1. 시작 시간 작은 순서대로 정렬
        Arrays.sort(time,(o1,o2)->{
            return o1[0]-o2[0];
        });
        
        // 2. 우선순위큐 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // 3. 배열 돌면서 
        // 없거나 뽑아도 시간 안되는경우 새로 생성
        // 되면 endTime 갱신
        int roomNumber = 1;
        for(int i=0;i<book_time.length;i++){
            int start = time[i][0];
            int end = time[i][1];
            
            if(pq.isEmpty()){
                pq.add(end+10);
            }else{
                int roomEnd = pq.peek();
                if(roomEnd <= start){
                    pq.poll();
                }
                pq.add(end+10);
            }
        }
        
        answer = pq.size();
        
        
        return answer;
    }

    static int calMinute(String[] time){
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        
        return hour*60 + minute;
    }
}