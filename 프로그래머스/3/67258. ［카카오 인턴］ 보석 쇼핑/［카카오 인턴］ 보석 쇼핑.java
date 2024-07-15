
import java.util.*;

// 알고리즘 : 투포인터
/*
- 모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간 찾기
1. Set으로 개수 세기 = N
2. 시작점, 끝점 0 투포인터 시작
3. 포인터의 흐름을 담는 Hashmap 선언
4. right 포인터 N과 map 크기 같아질때까지 이동
5. left 포인터 이동(N > map크기 일때까지 이동)
- 이동할때 해당개수 -1하면서 이동
- map size == N 인 경우, distance 최솟값 저장하면서 이동
6. (4,5)과정을 배열끝에 도달할때까지 반복
*/

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        int N = 0;
        int gems_size = gems.length;
        
        // 1. HashSet으로 개수 세기 = N
        Set<String> set = new HashSet<String>(Arrays.asList(gems));
        HashMap<String,Integer> map = new HashMap<>();
        
        N = set.size();
        
        // 2. 투포인터 첫번째 인덱스, 마지막 인덱스 0 에서 시작하기
        int left =0;
        int right = 0;
        int distance = Integer.MAX_VALUE;
        int[] distanceArr = {};

        // 투포인터 시작
        while(true){
            if (map.size() == N){
                // left 포인터 이동(N > map크기 일때까지 이동)
                map.put(gems[left],map.get(gems[left])-1);
                if(map.get(gems[left])==0) map.remove(gems[left]);
                left++;
            }else if(right == gems_size){
                break;
            }
            else {
                // right 포인터 N과 map 크기 같아질때까지 이동
                map.put(gems[right],map.getOrDefault(gems[right],0)+1);
                right++;
            }
            
            // map size == N 인 경우, distance 최솟값 저장하면서 이동
            if(map.size() == N){
                if(distance > (right-left+1)) {
                distance = (right-left+1);
                distanceArr = new int[]{left+1,right};
                }
            }
            
        }
        answer = distanceArr;
        return answer;
        
    }
}