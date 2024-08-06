import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while(s.length() > idx){
            if(s.charAt(idx)==' ') sb.append(" ");
            else if(idx==0 || s.charAt(idx-1)==' '){
                if(Character.isLetter(s.charAt(idx))){
                    sb.append(Character.toUpperCase(s.charAt(idx)));
                }else sb.append(s.charAt(idx));
            }else sb.append(Character.toLowerCase(s.charAt(idx)));
            idx++;
        }
            // String str = st.nextToken().toLowerCase();
            // if(Character.isLetter(str.charAt(0))) {
            //     sb.append(Character.toUpperCase(str.charAt(0)));
            // } else sb.append(str.charAt(0));
            // sb.append(str.substring(1)).append(" ");
        
        // answer = sb.toString();
        // answer = answer.substring(0,answer.length()-1);
        answer = sb.toString();
        return answer;
    }
}