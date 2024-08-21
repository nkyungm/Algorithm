import java.util.*;
import java.lang.*;
// 큰순으로 정렬해서 거기서 부터 빼주기

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int sum = k;
        // 정렬
        Arrays.sort(tangerine);
        HashMap<Integer,Integer> map = new HashMap<>();
        //해시맵에 개수 저장
        for(int i=0;i<tangerine.length;i++){
            map.put(tangerine[i],map.getOrDefault(tangerine[i],0)+1);
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());

        // value순 내림차순 정렬
        keySet.sort((o1,o2)-> map.get(o2).compareTo(map.get(o1)));
        
        //while문 돌아가면서 0이 되면 종료
        int idx = 0;
        while(sum > 0 && idx < tangerine.length){
            // 개수 빼기
            sum -= map.get(keySet.get(idx));
            answer++;
            idx++;
        }
        return answer;
    }
}