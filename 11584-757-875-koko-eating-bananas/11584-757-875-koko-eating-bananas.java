class Solution {
    // 완전탐색으로 풀기
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        return lower_bound(1,piles[piles.length-1],piles,h);
    }
    static int lower_bound(int left,int right,int[] piles,int h){
        int mid;
        int res = right;

        while(left <= right){
            mid = (left+right)/2;
            long totalTime = 0;
            for(int p: piles){
                totalTime += p / mid;
                if(p % mid != 0) totalTime++;
            }
            if(totalTime <= h){
                res = mid;
                right = mid-1;
            }else left = mid +1;
        }
        return res;
    }
}
