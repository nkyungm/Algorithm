import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        // 왼쪽으로 회전하면서 알맞은 문자열인지 확인
        answer += go(s);
        for(int i=0;i<s.length()-1;i++){
            String first = s.substring(0,1);
            s = s.substring(1) + first;
            // System.out.println(s);
            answer+= go(s);
        }
        
        
        return answer;
    }
    // 올바른 괄호 문자열인지 확인 함수
    private static int go(String s){
        Deque<Character> stack = new ArrayDeque<>();
        
        for(char c :s.toCharArray()){
            if(c =='[' || c== '(' || c=='{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()) return 0;
                char cp = stack.pop();
                if(c==']' && cp!='[') return 0;
                if(c==')' && cp!='(') return 0;
                if(c=='}' && cp!='{') return 0;
            }
        }
        
        if(!stack.isEmpty()) return 0;
        return 1;
    }
}