import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        // hashmap
        HashMap<String,Integer> map = new HashMap<>();
        for(String p : completion){
            map.put(p,map.getOrDefault(p,0)+1);
        }
        
        for(String person : participant){
            // 있으면 -1하고 넘기기
            if(!map.containsKey(person)){
                answer = person;
            }else{
                if(map.get(person) == 1){
                    // key 삭제
                    map.remove(person);
                }else{
                    map.put(person,map.get(person)-1);
                }
            }
        }
        
        return answer;
    }
}