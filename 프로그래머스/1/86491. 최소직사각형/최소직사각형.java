import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max_w =1;
        int max_h =1;
        int w = 0;
        int h = 0;
        
        for(int i=0;i<sizes.length;i++){
            int w1 = sizes[i][0]; // 큰거
            int h1 = sizes[i][1]; // 작은거
            
            if(w1 >= h1){
                w = w1;
                h = h1;
            }else{
                w = h1;
                h = w1;
            }
            
            if(w > max_w) max_w = w;
            if(h > max_h) max_h = h;
        }
        
        answer = max_w*max_h;
        
        return answer;
    }
}