import java.util.*;
import java.lang.*;
/**
- 자리별로 큰수 넣기
*/
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int L = numbers.length;
        String[] nStr = new String[L];
        
        for(int i=0;i<L;i++){
            nStr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(nStr,(o1,o2)->(o2+o1).compareTo(o1+o2));
        
        if(nStr[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<L;i++){
            sb.append(nStr[i]);
        }
        
        answer = sb.toString();
        
        return answer;
    }
}