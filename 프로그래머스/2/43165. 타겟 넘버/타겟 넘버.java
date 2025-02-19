import java.util.*;
import java.io.*;
class Solution {
    static int num=0;
    public int solution(int[] numbers, int target) {
        DFS(-1,0,numbers,target);
        // 해당 개수 구하기 : DFS, BFS
        int answer = num;
        return answer;
    }
    static void DFS(int idx,int total,int[] numbers,int target){
        // 종료 조건
        if(idx == numbers.length-1){
            if(total == target) num++;
            return;
        }
        // 반복 (그 뒤의 인덱스 +,- 더해 재귀돌림)
        DFS(idx+1,total+numbers[idx+1],numbers,target);
        DFS(idx+1,total-numbers[idx+1],numbers,target);
    }
}