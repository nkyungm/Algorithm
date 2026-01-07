import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i=0;i<participant.length;i++){
            String name = participant[i];
            map.put(name,map.getOrDefault(name,0)+1);
        }
        
        // completion에서 빼기
        for(int i=0;i<completion.length;i++){
            String name = completion[i];
            if(!map.containsKey(name)) continue;
            
            if(map.get(name) == 1) map.remove(name);
            else if(map.get(name) > 1){
                map.put(name,map.get(name)-1);
            }
            
        }
        
        answer = map.keySet().iterator().next();
        
        return answer;
    }
}