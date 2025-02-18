import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        // 1.commands 숫자만큼 반복문
        // 2. 배열만들어서 copy, 아니면 for문으로 넣기
        // 3. 정렬
        // 4. 해당 인덱스의 값 answer에 넣기
        for(int t=0;t<commands.length;t++){
            int i = commands[t][0];
            int j = commands[t][1];
            int k = commands[t][2];
            
            int[] arr = new int[j-i+1];
            for(int p=i-1;p<j;p++){
                arr[p-(i-1)] = array[p];
            }
            Arrays.sort(arr);
            answer[t] = arr[k-1];
        }
        return answer;
    }
}