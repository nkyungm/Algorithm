import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        List<Integer> ans = new ArrayList<>();
        
        // 1,2,3번 답 규칙 배열에 저장
        // 3사이즈 배열 만들어서 각자 answers 돌리면서 몇개 맞췄는지 저장
        // answer에 저장
        
        int[] p1 = new int[]{1,2,3,4,5}; //5
        int[] p2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5}; //8
        int[] p3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5} ; //10
        
        int[] cnt = new int[3];
        
        for(int i=0;i<answers.length;i++){
            if(p1[i%5] == answers[i]) cnt[0]++;
            if(p2[i%8] == answers[i]) cnt[1]++;
            if(p3[i%10] == answers[i]) cnt[2]++;
        }
        
        // 최대값 계산
        int max = Math.max(Math.max(cnt[0],cnt[1]),cnt[2]);
        for(int i=0;i<3;i++) if(max == cnt[i]) ans.add(i+1);
        
        int[] answer = new int[ans.size()];
        // list -> arr
        for(int i=0;i<ans.size();i++) answer[i] = ans.get(i); 
        
        return answer;
    }
}
