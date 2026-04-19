import java.util.*;
import java.io.*;
class Solution {
    static HashMap<String,Integer> wantMap;
    static HashMap<String,Integer> discountMap;
    // 알고리즘 : HaspMap + 슬라이딩 윈도우
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        int startIdx = 0;
        int endIdx = 0;
        int matchCount = 0;
        wantMap = new HashMap<>();
        discountMap = new HashMap<>();
        
        // wantMap 세팅
        for(int i=0;i<want.length;i++){
            wantMap.put(want[i],number[i]);
        }
        
        // discount 처음 세팅 (0~9)
        for(int i=0;i<10;i++){
            discountMap.put(discount[i],discountMap.getOrDefault(discount[i],0)+1);
        }
        endIdx = 9;
        
        // matchCount 계산
        for(String key : wantMap.keySet()){
            if(discountMap.getOrDefault(key,0) >= wantMap.get(key)) matchCount++;
        }
        
        // 현재 처음 range에서 충족하는지 확인
        if(matchCount == wantMap.size()) answer++;
        
        // 종료조건 : endIdx가 discount 마지막에 도달했을때
        while(endIdx < discount.length-1){
            // startIdx 확인 + matchCount 체크
            String removeItem = discount[startIdx];
            boolean matchFlag = false;
            
            // 이전 match 확인
            if(wantMap.containsKey(removeItem) && discountMap.get(removeItem) >= wantMap.get(removeItem)) matchFlag = true;
            
            // wantMap에 있는지 확인 + matchCount 감소 확인
            discountMap.put(removeItem,discountMap.get(removeItem)-1);
            if(wantMap.containsKey(removeItem)){
                if(matchFlag && discountMap.get(removeItem) < wantMap.get(removeItem)) matchCount--;
            } 
            startIdx ++;
            
            // endIdx 확인
            endIdx ++;
            matchFlag = false;
            String addItem = discount[endIdx];
            
            // 추가 match 확인
            if(wantMap.containsKey(addItem) && discountMap.getOrDefault(addItem,0) < wantMap.get(addItem)) matchFlag = true;
            
            discountMap.put(addItem,discountMap.getOrDefault(addItem,0)+1);
            // wantMap에 있는지 확인 + matchCount 증가 확인
            if(wantMap.containsKey(addItem)){
                if(matchFlag && discountMap.get(addItem) >= wantMap.get(addItem)) matchCount++;
            }
            
            if(matchCount == wantMap.size()) answer++;
        }
        
        return answer;
    }
    // private static boolean countCheck(String[] want, int[] number){
    //     for(int i=0;i<want.length;i++){
    //         // discount에 개수 충족되는지 체크
    //         if(!discountMap.containsKey(want[i])) return false;
    //         if(discountMap.get(want[i]) < number[i]) return false;
    //     }
    //     return true;
    // }
}