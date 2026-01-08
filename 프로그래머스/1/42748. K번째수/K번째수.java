import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];

        for (int idx = 0; idx < commands.length; idx++) {
            int i = commands[idx][0];
            int j = commands[idx][1];
            int k = commands[idx][2];

            // 1️⃣ 배열 자르기
            int[] temp = Arrays.copyOfRange(array, i - 1, j);

            // 2️⃣ 정렬
            Arrays.sort(temp);

            // 3️⃣ k번째 수
            answer[idx] = temp[k - 1];
        }
        
        return answer;
    }
}