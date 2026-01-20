import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = false;
        Deque<Character> stack = new ArrayDeque<>();
        
        // "(" 인 경우 스택에 넣고 ")"일때 빼서 비교
        
        // string s-> char c 변경
        for(char c : s.toCharArray()){
            if(c=='(') {
                stack.push(c);
            }else if(c==')'){
                if(stack.isEmpty() || stack.pop() != '('){
                    return answer;
                }
            }
        }
        if(stack.isEmpty()) answer = true;

        return answer;
    }
}