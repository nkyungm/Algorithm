import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        // 공식 : (n1+1)(n2+1)..(nk+1) -1
        // 그룹별로 선택하는 경우의 수 생각(그룹별로 따로 생각)
        // A(1,2,3,4)를 뽑는 경우의 수 : 1,2,3,4,안뽑음 (n+1)
        HashMap<String,Integer> map = new HashMap<>();
        
        for(String[] cloth : clothes){
            System.out.println(cloth[1]);
            map.put(cloth[1],map.getOrDefault(cloth[1],0)+1);
        }
        
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            answer *= (entry.getValue())+1;
        }
        answer --;
        
        return answer;
    }
}