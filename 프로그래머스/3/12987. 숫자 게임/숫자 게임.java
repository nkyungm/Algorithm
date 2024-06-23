import java.util.*;

// 알고리즘 : 이분탐색(upper bound)
// 이진탐색으로 바로 다음꺼 찾게해서 다음꺼 없으면 넘어가기?
/*
1. B배열 오름차순 정렬
2. A배열 for문 돌리면서 upper bound 인덱스 값 찾기
3. 인덱스가 B배열 안에 있으면 answer+1
4. B배열에서 없애기
5. 없으면 해당 값보다 큰게 없으므로 continue
*/

class Solution {
    static ArrayList<Integer> arr = new ArrayList<>();

    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(B);
        int size = A.length;
        
        // int배열에서 ArrayList배열로 변환
        for(int i:B) arr.add(i);
        
        for(int i=0;i<size;i++){
            int target = upperBound(0,arr.size(),A[i]);
            if(target >= arr.size()) continue;
            arr.remove(target);
            answer++;
        }
        
        
        return answer;
    }
    // 이분탐색(상한)
    static int upperBound(int left,int right,int key){
        int mid =0;
        while(left < right){
            mid = (left+right)/2;
            if(arr.get(mid) > key) right = mid;
            else left = mid+1;
        }
        return left;
    }
    
}