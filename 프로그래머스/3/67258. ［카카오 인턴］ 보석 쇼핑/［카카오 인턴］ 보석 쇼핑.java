import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        int ansStart = 0;
        int ansEnd = gems.length;
        // 전체 gems 저장 hashMap
        // 1. 총 보석의 개수 저장
        // 2. 뒤에서 빼다가 더이상 못빼면 앞에서 빼기
        int totalCnt = 0;
        HashMap<String,Integer> gemsMap = new HashMap<>();
        HashMap<String,Integer> map = new HashMap<>();
        // 저장
        for(String gem : gems){
            gemsMap.put(gem, gemsMap.getOrDefault(gem,0)+1);
        }
        // 보석 전체 종류
        totalCnt = gemsMap.size();
        
        // 둘다 왼쪽에서 시작
        int start =0;
        int end = 0;
        
        // 투포인터
        while(true){
            // map이 모든 종류가 포함되는지 확인 -> 아니면 end++
            if(map.size() < totalCnt){
                if(end == gems.length) break;
                map.put(gems[end],map.getOrDefault(gems[end],0)+1);
                end++;
            }else{ // 모든 종류인 경우
                // 현재 구간(start ~ end-1)이 정답 후보, 정답갱신
                if(ansEnd - ansStart > end -start){
                    ansStart = start;
                    ansEnd = end;
                }
                // 왼쪽 제거
                if(map.get(gems[start]) ==1){
                    map.remove(gems[start]);
                }else{
                    map.put(gems[start],map.get(gems[start])-1);
                }
                start++;
            }
        }
        
        answer = new int[]{ansStart+1,ansEnd};
        
        return answer;
    }
}