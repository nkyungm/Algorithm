import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        // 1. 0 1 3 5 6 정렬
        // 2. 0~citations[citations.length-1] 반복
        // 3. 이진탐색 lower_bound로 idx 찾아서 비교
        // 만약 num =2가 나왔으면 2의 lower_bound = 3의 값인 idx=2
        // 1조건 : n-idx >= num 
        // 2조건 : idx <= num
        Arrays.sort(citations);
        for(int i=0;i<=citations[citations.length-1];i++){
            int num = i;
            int idx = lower_bound(0,citations.length,num,citations);
            if((citations.length-idx) < num) continue;
            if(idx > num) continue;
            answer = num;
        }
        return answer;
    }
    static int lower_bound(int left,int right,int target,int[] arr){
        int mid;
        while(left < right){
            mid = (left+right)/2;
            if(arr[mid] < target) left = mid+1;
            else right = mid;
        }
        return left;
    }
}