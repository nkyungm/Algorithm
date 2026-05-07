import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        // 최대 100x100
        int[][] arr = new int[100][100];
        // 초기 i행 j열 숫자 : ((i-1) X columns +j)
        // 1. 2차원 배열에 값 넣기
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=columns;j++){
                arr[i-1][j-1] = (i-1) * columns +j;
            }
        }
        
        for(int i=0;i<queries.length;i++){
            int x1 = queries[i][0]-1;
            int y1 = queries[i][1]-1;
            int x2 = queries[i][2]-1;
            int y2 = queries[i][3]-1;
            
            answer[i] = pull(x1,y1,x2,y2,arr);
        }
        
        return answer;
    }
    private static int pull(int x1,int y1, int x2,int y2,int[][] arr){
        // 가장 큰 값으로 초기화
        int minAns = arr[x1][y1];
        int temp = 0;
        
        // 2. 회전 방법
        // - 2) 2차원배열 자체로 돌리기 (함수)
        //    - 최소값 계산해서 return
        
        // 1,1,4,3
        // 11(x1y1) 12 13(x1y2) 23 33 43(x2y2) 
        // 42 41(x2y1) 31 21 11(x1y1)
        
        temp = arr[x1][y1];
        // 1) 왼쪽 위 :y1고정 x2 -> x1
        for(int x=x1+1;x<=x2;x++){
            arr[x-1][y1] = arr[x][y1];
            minAns = Math.min(minAns,arr[x-1][y1]);
        }
        // 2) 아래 왼쪽 : x2고정 y2 -> y1
        for(int y=y1+1;y<=y2;y++){
            arr[x2][y-1] = arr[x2][y];
            minAns = Math.min(minAns,arr[x2][y-1]);
        }
        // 3) 오른쪽 아래 : y2고정 x1 -> x2
        for(int x=x2-1;x>=x1;x--){
            arr[x+1][y2] = arr[x][y2];
            minAns = Math.min(minAns,arr[x+1][y2]);
        }
        // 4) 위쪽 오른쪽 : x1고정 y1 -> y2
        for(int y= y2-1;y>=y1;y--){
            arr[x1][y+1] = arr[x1][y];
            minAns = Math.min(minAns,arr[x1][y+1]);
        }
        arr[x1][y1+1] = temp;
        
        
        return minAns;
    }
}