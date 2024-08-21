import java.util.*;

// set 하나로 풀수 있음

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        // 중복 제거하고 개수를 세기 위한 set
        Set<Integer> set = new HashSet<>();
        
        for(int i=1;i<=elements.length;i++){
            for(int j=0;j<elements.length;j++){
                int sum =0;
                for(int k=j;k<j+i;k++){
                    sum+=elements[k%elements.length];
                }
                set.add(sum);
            }
        }
        answer = set.size();
        
        return answer;
    }
}