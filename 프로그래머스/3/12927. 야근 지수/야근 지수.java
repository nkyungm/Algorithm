import java.util.*;

// 알고리즘 : 그리디
/*
1. works를 우선순위큐에 넣기(내림차순 정렬)
2. for문으로 n번 반복, 빼서 -1하고 넣기
-> 만약, 빼서 -1한것이 0이면 queue에서 빼기
3. queue빼면서 제곱해서 다 더해주기
*/

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        // queue에 배열 값들 넣는 방법
        for(int i:works) queue.add(i);
        // n번 반복
        for(int i=0;i<n;i++){
            if(queue.isEmpty()) return 0;
            int maxWork = queue.poll();
            // 만약, 빼서 -1한것이 0이면 queue에서 빼기
            if(maxWork-1 > 0) queue.add(maxWork-1);
        }
        
        if(queue.isEmpty()) return 0;
        while(!queue.isEmpty()){
            int work = queue.poll();
            answer += work * work;
        }
        
        return answer;
    }
}