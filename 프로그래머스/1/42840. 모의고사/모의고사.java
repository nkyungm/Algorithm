import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> arr = new ArrayList<>();
        int[] answer = null;
        
        int[] p1 = new int[]{1, 2, 3, 4, 5};
        int[] p2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] ans = new int[3];
        // int p1Ans=0;
        // int p2Ans=0;
        // int p3Ans=0;
        
        for(int i =0;i<answers.length;i++){
            if(p1[i%p1.length] == answers[i]) ans[0] ++;
            if(p2[i%p2.length] == answers[i]) ans[1] ++;
            if(p3[i%p3.length] == answers[i]) ans[2] ++;
        }
        
        int max = Math.max(Math.max(ans[0],ans[1]),ans[2]);
        
        for(int i=0;i<ans.length;i++){
            if(max > ans[i]) continue;
            arr.add(i+1);
        }
        
        answer = new int[arr.size()];
        
        for(int i=0;i<arr.size();i++) answer[i] = arr.get(i);
        
        return answer;
    }
}