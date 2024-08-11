import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        //yellow를 row,col 경우의 수를 돌아가면서
        //yellow에 해당하는 brown수가 맞으면 return
        int n = go(brown,yellow);
        answer = new int[]{(yellow/n)+2,n+2};
        return answer;
    }
    // 약수 구하기
    static int go(int brown,int yellow){
        int sqrt = (int)Math.sqrt(yellow);
        // ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1;i<=sqrt;i++){
            if(yellow%i!=0) continue;
            // arr.add(i);
            int n1 = i;
            int n2 = yellow/i;
            if(((n2*2) + ((n1+2)*2)) != brown) continue;
            return i;
        }
        return 0;
        // System.out.println(arr);
    }
}