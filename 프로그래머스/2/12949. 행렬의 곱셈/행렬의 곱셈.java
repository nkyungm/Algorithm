import java.util.*;
import java.io.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        int sum=0;
        
        for(int i=0;i<arr1.length;i++){
            for(int k=0;k<arr2[0].length;k++){
                sum =0;
                for(int j=0;j<arr1[i].length;j++){ 
                    sum += (arr1[i][j] * arr2[j][k]);
                }

                answer[i][k] = sum;
            }
        }
        
        return answer;
    }
}