import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        // 1. 배열에 채우기
        int[][] arr = new int[rows][columns];
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=columns;j++){
                arr[i-1][j-1] = (i-1)*columns + j;
            }
        }
        // 2. 회전
        for(int i=0;i<queries.length;i++){
            int x1 = queries[i][0]-1;
            int y1 = queries[i][1]-1;
            int x2 = queries[i][2]-1;
            int y2 = queries[i][3]-1;
            answer[i] = go(arr,x1,y1,x2,y2);
        }
        return answer;
    }
    private static int go(int[][] arr, int x1,int y1,int x2,int y2){
        // 첫번째 저장
        int temp = arr[x1][y1];
        int answer = temp;
        
        // 왼위 (y1 고정)
        for(int x=x1;x<x2;x++){
            arr[x][y1] = arr[x+1][y1];
            answer =Math.min(answer,arr[x][y1]);
        }
        
        // 아래 왼 (x2 고정)
        for(int y=y1;y<y2;y++){
            arr[x2][y] = arr[x2][y+1];
            answer =Math.min(answer,arr[x2][y]);
        }
        
        // 오른쪽 아래 (y2 고정)
        for(int x=x2;x>x1;x--){
            arr[x][y2] = arr[x-1][y2];
            answer= Math.min(answer,arr[x][y2]);
        }
        // 위 오른쪽 (x1 고정)
        for(int y=y2;y>y1;y--){
            arr[x1][y] = arr[x1][y-1];
            answer=Math.min(answer,arr[x1][y]);
        }
        
        arr[x1][y1+1] = temp;
        
        return answer;
    }
}