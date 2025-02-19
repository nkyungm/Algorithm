import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[] record) {
        List<String[]> list = new ArrayList<>();
        
        // 1. hashmap (key = id,value = 닉네임) 생성
        // 2. enter -> hashmap에 없으면 추가, answer에도 추가
        // => 있는데 닉네임이 다르면 변경하고 answer 추가
        // 3. leave -> answer에만 추가
        // 4. change -> hashmap 값변경
        
        HashMap<String,String> map = new HashMap<>();
        
        for(int i=0;i<record.length;i++){
            StringTokenizer st = new StringTokenizer(record[i]);
            String command = st.nextToken();
            String id = st.nextToken();
            String name;
            switch(command){
                case "Enter":
                    name = st.nextToken();
                    if(map.get(id)== null) map.put(id,name);
                    else map.put(id,name);
                    list.add(new String[]{id,"Enter"});
                    break;
                case "Leave":
                    list.add(new String[]{id,"Leave"});
                    break;
                case "Change":
                    name = st.nextToken();
                    map.put(id,name);
                    break;
            }
        }
        String[] answer = new String[list.size()];
        for(int i=0;i<list.size();i++) {
            String[] s = list.get(i);
            if(s[1].equals("Enter")) answer[i] = map.get(s[0])+"님이 들어왔습니다.";
            else answer[i] = map.get(s[0])+"님이 나갔습니다.";
        }
        
        
        return answer;
    }
}