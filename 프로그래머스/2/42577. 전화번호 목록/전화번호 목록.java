import java.util.*;
// 해시문제 확인법 : “어떤 것이 존재하는지 빠르게 확인”, “중복 / 접두어 / 이미 등장한 값”
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        // 해시로 풀어야하는이유
        //1. 전화번호 저장 : O(n)
        HashSet<String> set = new HashSet<>(); // value 필요없는 경우 HashSet 사용
        for(String phone : phone_book){
            set.add(phone);
        }
        //2. 번호의 접두어를 잘라가며 검사(반대로 비교, 짤라가면서 짜른값이 안에 있는지 확인)
        // 시간복잡도 : O(n * m)
        for(String phone : phone_book){
            for(int i=1;i<phone.length();i++){
                if(!set.contains(phone.substring(0,i))) continue; // O(1)
                return false;
            }
        }
        
        return answer;
        // 총 시간 복잡도 : O(n*m)
    }
}