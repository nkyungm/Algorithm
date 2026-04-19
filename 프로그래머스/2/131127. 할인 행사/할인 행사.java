import java.util.*;
import java.io.*;
class Solution {
    static HashMap<String,Integer> discountMap;
    // 알고리즘 : HaspMap + 슬라이딩 윈도우
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        int startIdx = 0;
        int endIdx = 0;
        discountMap = new HashMap<>();
        
        // discount 처음 세팅 (0~9)
        for(int i=0;i<10;i++){
            discountMap.put(discount[i],discountMap.getOrDefault(discount[i],0)+1);
        }
        endIdx = 9;
        if(countCheck(want,number)) answer++;
        
        // 종료조건 : endIdx가 discount 마지막에 도달했을때
        while(endIdx < discount.length-1){
            // startIdx 전에꺼 빼고 +1
            discountMap.put(discount[startIdx],discountMap.get(discount[startIdx])-1);
            startIdx ++;
            // endIdx도 동일하게 진행 (반대로)
            endIdx ++;
            discountMap.put(discount[endIdx],discountMap.getOrDefault(discount[endIdx],0)+1);
            // wantMap와 discountMap 개수 포함되는지 체크
            if(countCheck(want,number)) answer++;
        }
        
        return answer;
    }
    private static boolean countCheck(String[] want, int[] number){
        for(int i=0;i<want.length;i++){
            // discount에 개수 충족되는지 체크
            if(!discountMap.containsKey(want[i])) return false;
            if(discountMap.get(want[i]) < number[i]) return false;
        }
        return true;
    }
}