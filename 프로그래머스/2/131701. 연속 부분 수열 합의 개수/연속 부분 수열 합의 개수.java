import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int eleLength = elements.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<eleLength;i++){
            for(int j=0;j<eleLength;j++){
                int sum = 0;
                for(int k=i;k<i+j;k++){
                    sum+=elements[k%eleLength];
                }
                set.add(sum);
            }
        }
        answer = set.size();
        return answer;
    }
}