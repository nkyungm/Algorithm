import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int num_size = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int num:nums){
            map.put(num,map.getOrDefault(map.get(num),0)+1);
        }
        
        answer = map.size() - num_size/2 > 0 ? num_size/2 : map.size();
        
        return answer;
    }
}