class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(0,nums.length,target,nums);
    }
    static int binarySearch(int left, int right, int key,int[] nums){
        while(left < right){
            int mid = (left+ right)/2;
            if(key > nums[mid]) left = mid +1;
            else if(key < nums[mid]) right = mid;
            else{
                right = mid;
                return mid;
            }
        }
        return -1;
    }
}