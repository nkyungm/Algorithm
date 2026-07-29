import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        // 투포인터 : 리스트 순차적 접근하면서 두개의 점 위치 기록하며 처리
        // 1. hashmap으로 총 개수 파악
        HashMap<String,Integer> gemMap = new HashMap<>();
        HashMap<String,Integer> curMap = new HashMap<>();
        int totalCnt = 0;
        
        for(String gem : gems){
            gemMap.put(gem, gemMap.getOrDefault(gem,0)+1);
        }
        totalCnt = gemMap.size();
        // 2. start, end 0에서 시작
        int start = 0;
        int end = 0;
        int ansStart = 0;
        int ansEnd = gems.length;
        
        while(true){
            // 3.1 총 종류가 다 포함되지 않으면 end ++
            if(curMap.size() < totalCnt){
                // 종료조건
                if(end == gems.length) {
                    break;
                }
                curMap.put(gems[end],curMap.getOrDefault(gems[end],0)+1);
                end++;
            }else{ // 3.2 종류가 다 채워지면 start ++, 최적의 값 저장
                // 최적의 값 저장
                if(ansEnd - ansStart > end - start){
                    ansStart = start;
                    ansEnd = end;
                }
                // start 이동하면서 보석 빼기
                if(curMap.get(gems[start]) > 1 ){
                    curMap.put(gems[start],curMap.get(gems[start])-1);
                }else{
                    curMap.remove(gems[start]);
                }
                start++;
            }
            
        }
        
        answer = new int[]{ansStart+1,ansEnd};
        
        return answer;
    }
}