import java.util.*;
import java.math.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max_row = 0;
        int max_col = 0;
        
        // 무조건 가로나 세로를 더 큰것으로 만들어서
        // 단순 비교하면서 더 큰것 갱신
        
        for(int i=0;i<sizes.length;i++){
            int row = sizes[i][0];
            int col = sizes[i][1];
            if(row < col){
                int temp = row;
                row = col;
                col = temp;
            }
            
            if(row > max_row){
                max_row = row;
            }
            if(col > max_col){
                max_col = col;
            }
        }
        answer = max_row * max_col;
        
        
        return answer;
    }
}