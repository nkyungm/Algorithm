import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        StringTokenizer st = null;
        // muzi - frodo, neo
        // apeach - frodo, muzi
        // frodo - neo
        
        // muzi가 어떤 사람 신고했는지 저장 필요 (중복 제거)
        // => HashMap<String,Set<String>>
        // 해당 id가 몇번 신고당했는지 확인 필요
        // => hashmap (중복 여부 체크 후 hashmap 저장)
        
        HashMap<String,Set<String>> map = new HashMap<>();
        HashMap<String,Integer> cntMap = new HashMap<>();
        
        for(String r : report){
            st = new StringTokenizer(r);
            String from_id = st.nextToken();
            String to_id = st.nextToken();
            
            // 신고를 이미 했는지 확인
            if(!map.containsKey(from_id)){ // map안에 있는지 확인
                map.put(from_id, new HashSet<>());
            }
            Set<String> set = map.get(from_id);
            int beforeSize = set.size();
            // 신고id 넣기
            set.add(to_id);
            int afterSize = set.size();
            map.put(from_id,set);
            // size 다르면 cntMap에 +1
            if(beforeSize+1 == afterSize){
                cntMap.put(to_id, cntMap.getOrDefault(to_id,0)+1);
            }
        }
        
        //id_list 돌면서 
        for(int i=0;i<id_list.length;i++){
            String id = id_list[i];
            Set<String> set = map.getOrDefault(id,new HashSet<>());
            for(String set_id : set){
                // cntMap에서 k 이상이면 +1
                if(cntMap.get(set_id) >=k){
                    answer[i]++;
                }
            }
        }

        return answer;
    }
}