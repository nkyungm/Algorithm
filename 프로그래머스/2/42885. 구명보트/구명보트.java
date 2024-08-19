import java.util.*;
// 탐욕법, 투포인터
// 정렬
// 무거운 사람 + 가벼운 사람

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length-1;
        while(left <= right){
            if(left == right){
                answer++;
                break;
            }
            if (people[left]+people[right] <=limit) left ++;
            right --;
            answer++;
        }
        
        return answer;
    }
}