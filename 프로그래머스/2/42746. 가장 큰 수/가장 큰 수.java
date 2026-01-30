import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        
        // string으로 바꿔서 정렬
        // int -> string : String.valueOf
        for(int i=0;i<numbers.length;i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        
        // 내림차순
        Arrays.sort(arr,(a,b) -> (b+a).compareTo(a+b));
        
        StringBuilder sb = new StringBuilder();
        for(String s : arr){
            sb.append(s);
        }
        
        // 다 0인 경우
        if(arr[0].equals("0")) return "0";
        
        return sb.toString();
    }
}