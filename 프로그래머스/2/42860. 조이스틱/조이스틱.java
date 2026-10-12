// 앞 뒤 BFS로 최소 판단
import java.util.*;
import java.io.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int nameLen = name.length();
        List<Integer> list = new ArrayList<>();
        
        // int next = 1; 틀린 지점
        
        int lrCnt = nameLen;
        
        // 알파벳 다음, 이전 개수 세기
        for(int i=0;i<nameLen;i++){
            char c = name.charAt(i);
            
            answer += Math.min('Z'-c+1,c-'A');
            
            // next 갱신
            int next = i + 1; // 고친 지점
            while(next<nameLen && name.charAt(next)=='A'){
                next++;
            }
            
            int right = 2*i + (nameLen-next);
            int left = i + 2* (nameLen-next);
            
            lrCnt = Math.min(Math.min(lrCnt,right),left);
        }
        answer+=lrCnt;

        
        return answer;
    }

    
}