import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        // set 준비
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        char endStr = words[0].charAt(words[0].length()-1);
        int target = 0;
        // System.out.println(endStr);
        // 반복문 돌리면서 확인
        for(int i=1;i<words.length;i++){
            // 1. endStr과 앞글자 일치하는 지 확인
            if(!(endStr==(words[i].charAt(0)))) {
                target = i;
                break;
            }
            endStr = words[i].charAt(words[i].length()-1);
            // 2. 앞에 나온 것과 동일한 것인지 확인
            int setSize = set.size();
            set.add(words[i]);
            if(setSize == set.size()){
                target = i;
                break;
            }
        }
        System.out.println(target);
        // answer 넣기
        if(target == 0) return new int[]{0,0};
        target++;
        if(target %n==0){
            answer = new int[]{n,target/n};
        }else{
            answer = new int[]{target%n,target/n+1};
        }

        return answer;
    }
}