import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        // 1. 정렬
        Arrays.sort(arr);
        
        // 2. 작은것들부터 2개씩 최소공배수 구하기
        // 1개인 경우 return
        if(arr.length < 2) return arr[0];
        for(int i=1;i<arr.length;i++){
            arr[i] = findMultiple(arr[i-1],arr[i]);
        }
        return arr[arr.length-1];
    }
    // 최소 공배수 찾기
    static int findMultiple(int a,int b){
        int minN=0;
        int maxN=0;
        if(a <b) {
            minN = a;
            maxN = b;
        }else{
            minN = b;
            maxN = a;
        }
        for(int i=1;i<=minN;i++){
            // 나누어 떨어지면 종료
            if((maxN*i)%minN==0) return maxN*i;
        }
        return minN*maxN;
    }
}