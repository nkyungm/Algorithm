import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char temp = '1';
        
        // char 배열로 변경
        char[] arr = s.toCharArray();
        // 2) stack으로 올바른 문자열인지 판단 (함수)
        if(check(arr)) answer++;
            
        // 1) 회전
        
        for(int i=0;i<s.length()-1;i++){ // s-1만큼 회전
            temp = arr[0];
            for(int j=1;j<arr.length;j++){
                arr[j-1] = arr[j];
            }
            arr[arr.length-1] = temp;
            // 2) stack으로 올바른 문자열인지 판단 (함수)
            if(check(arr)) answer++;
        }
        
        
        return answer;
    }
    private static boolean check(char[] arr){
        Deque<Character> stack = new ArrayDeque<>();
        // stack 삽입 : push , 삭제 pop
        
        for(char c : arr){
            if(c=='[' || c=='(' || c=='{' ) stack.push(c);
            else{
                // stack 비었으면 return
                if(stack.isEmpty()) return false;
                // 짝 안맞으면 return
                char cp = stack.pop();
                if(c==']' && cp!='[') return false;
                if(c==')' && cp!='(') return false;
                if(c=='}' && cp!='{') return false;
            }
        }
        
        // stack 안비었으면 false
        if(!stack.isEmpty()) return false;
        return true;
    }
}