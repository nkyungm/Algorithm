import java.util.*;
import java.io.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        // 1. 숫자말고 String으로 변환
        // 2. o1+o2랑 o2+o1중 더 큰거 비교 => 붙였을때를 비교하는 거니까 610,106 비교
        String[] arr = new String[numbers.length];
        
        for(int i=0;i<numbers.length;i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr,(o1,o2)-> (o2+o1).compareTo(o1+o2));
        
        // 중요) 처음이 0인 경우는 무조건 0 출력
        if(arr[0].equals("0")) return "0";
        
        for(int i=0;i<numbers.length;i++) sb.append(arr[i]);
        answer = sb.toString();
        
        return answer;
    }
}