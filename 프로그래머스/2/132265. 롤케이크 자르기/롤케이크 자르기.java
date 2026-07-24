import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        // 처음에 슬라이딩 윈도우로 파악함
        // 이게 hashmap?
        // 1 2 1 3 1 4 1 2
        // 총 개수 구하기 totalCnt
        // hashmap?? 구간 파악
        // hashmap 2개 사용해서 개수 파악
        // hashmap 1개에 다 넣어두고, for문으로 1개씩 뺴고 다른 hashmap에 넣으면서 개수 동일한지 확인
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        int totalCnt =0;
        
        // 전체 넣기
        for(int top : topping){
            map1.put(top,map1.getOrDefault(top,0)+1);
        }
        totalCnt = map1.size();
        
        // 앞에서부터 한개씩 빼면서 size 동일하면 +1
        for(int top : topping){
            // map1에서 빼기
            if(map1.get(top) == 1){
                map1.remove(top);
            }else{
                map1.put(top,map1.get(top)-1);
            }
            // map2에 넣기
            map2.put(top,map2.getOrDefault(top,0)+1);
            
            // 두개 사이즈 비교
            if(map1.size() == map2.size()){
                answer++;
            }
        }
        
        return answer;
    }
}