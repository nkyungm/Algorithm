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
        for(int i=0;i<record.length;i++){
            st = new StringTokenizer(record[i]);
            String comm = st.nextToken();
            String id = st.nextToken();
            String nickname = "";
            if(!comm.equals("Leave")){
                nickname = st.nextToken();
                map.put(id,nickname);
            }
            
            if(!comm.equals("Change")){
                n++;
            }
        }
        
        answer = new String[n];
        int j=0;
        for(int i=0;i<record.length;i++){
            st = new StringTokenizer(record[i]);
            String comm = st.nextToken();
            String id = st.nextToken();
            String nickname = "";
            if(!comm.equals("Leave")){
                nickname = st.nextToken();
            }
            
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