import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        
        for(int n : arr){
            if(!stack.isEmpty() && stack.peek() ==n) continue;
            stack.push(n);
        }
        
        // list로 옮기기
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        
        Collections.reverse(list);
        answer = list.stream()
        .mapToInt(Integer::intValue)
        .toArray();

        return answer;
    }
}