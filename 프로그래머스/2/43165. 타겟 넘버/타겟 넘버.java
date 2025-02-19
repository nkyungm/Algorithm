import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = BFS(numbers,target);
        // 해당 개수 구하기 : DFS, BFS
        // visited 방문배열을 만들어서 큐에 없으면 종료
        // 큐넣을때) 방문 체크하고 false면, 다음인덱스 값 +,- 큐에 넣기
        // 그냥 큐넣을때 마지막 노드일 경우, 개수 계산
        
        return answer;
    }
    static int BFS(int[] numbers,int target){
        int num=0;
        // 큐 생성
        Queue<int[]> queue = new ArrayDeque<>();
        // boolean[] visited = new boolean[numbers.length];
        // 첫번째 요소 넣기
        queue.add(new int[]{0,numbers[0]});
        queue.add(new int[]{0,-numbers[0]});
        // visited[0] = true;
        while(!queue.isEmpty()){
            int[] v = queue.poll();
            // 확인 조건
            if(v[0]==numbers.length-1) {
                if(v[1]==target) num++;
                continue;
            }
            queue.add(new int[]{v[0]+1,v[1]+numbers[v[0]+1]});
            queue.add(new int[]{v[0]+1,v[1]-numbers[v[0]+1]});
        }
        return num;
    }
}