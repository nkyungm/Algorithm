import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[]{0,0};
        // 해시맵으로 cnt 저장
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> q1 = new PriorityQueue<>((a,b) -> b-a);
        PriorityQueue<Integer> q2 = new PriorityQueue<>((a,b) -> a-b);
        
        // 만약 최대값을 삭제하면 최소값 큐에는 어떻거ㅔ 할것인가 -> 해시맵으로 들어온 횟수 저장
        StringTokenizer st = null;
        for(String op : operations){
            st = new StringTokenizer(op);
            
            String com = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            // 1. | 인 경우 큐, 해시맵에 넣기
            if(com.equals("I")){
                q1.offer(num);
                q2.offer(num);
                map.put(num,map.getOrDefault(num,0)+1);
            }else{
                // 1 : 최대값 삭제 -> while로 큐 빌때나 최대값 발견한 경우
                if(num == 1){
                    while(!q1.isEmpty()){
                        int max = q1.poll();
                        if(map.get(max)>0){
                            map.put(max,map.get(max)-1);
                            break;
                        }
                    }
                }else{
                    while(!q2.isEmpty()){
                        int min = q2.poll();
                        if(map.get(min)>0){
                            map.put(min,map.get(min)-1);
                            break;
                        }
                    }
                }
            }
        }
        
        while(!q1.isEmpty()){
            int max = q1.poll();
            if(map.get(max)>0){
                answer[0] = max; 
                break;
            }
        }
        
        while(!q2.isEmpty()){
            int min = q2.poll();
            if(map.get(min)>0){
                answer[1] = min; 
                break;
            }
        }

        return answer;
    }
}