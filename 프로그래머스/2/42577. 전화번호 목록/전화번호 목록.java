import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        // 해시로 풀어야하는이유
        //1. 전화번호 저장
        HashSet<String> set = new HashSet<>();
        for(String phone : phone_book){
            set.add(phone);
        }
        //2. 번호의 접두어를 잘라가며 검사(반대로 비교, 짤라가면서 짜른값이 안에 있는지 확인)
        for(String phone : phone_book){
            for(int i=1;i<phone.length();i++){
                if(!set.contains(phone.substring(0,i))) continue;
                return false;
            }
        }
        
        return answer;
    }
}