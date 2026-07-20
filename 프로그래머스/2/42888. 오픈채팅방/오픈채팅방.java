import java.util.*;
import java.io.*;
class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        List<String> arr = new ArrayList<>();
        StringTokenizer st = null;
        
        HashMap<String,String> map = new HashMap<>();
        
        // Hash Map에 {id, nickname} 저장
        int n =0;
        for(String r : record){
            String[] split = r.split(" ");
            String comm = split[0];
            String id = split[1];
            
            if(!comm.equals("Leave")){
                String nickname = split[2];
                map.put(id,nickname);
            }
            
            if(comm.equals("Enter") || comm.equals("Leave")){
                n++;
            }
        }
        
        answer = new String[n];
        int j=0;
        for(String r : record){
            String[] split = r.split(" ");
            String comm = split[0];
            String id = split[1];
            
            if(comm.equals("Change")) continue;
            if(comm.equals("Enter")){
                answer[j] = map.get(id)+"님이 들어왔습니다.";
            }else{
                answer[j] = map.get(id)+"님이 나갔습니다.";
            }
            j++;
        }

        return answer;
    }
}