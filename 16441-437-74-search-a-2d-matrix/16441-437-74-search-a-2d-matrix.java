class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = lower_bound(0,matrix.length,target, matrix);
        if(row < matrix.length && matrix[row][0] == target) return true;
        if(row == 0) return false; 
        row--;
        System.out.println(row);
        int col = lower_bound_col(row,0,matrix[row].length,target,matrix);
        System.out.println(col);
        if(col < matrix[row].length && matrix[row][col] == target) return true;
        return false;
    }
    // 행 이분탐색
    static int lower_bound(int left,int right,int key, int[][] matrix){
        int mid;
        while(left < right){
            mid = (left+right)/2;
            if(matrix[mid][0] < key) left = mid+1;
            else right = mid;
        }
        return left;
    }
    // 열 이분탐색
    static int lower_bound_col(int row,int left,int right,int key, int[][] matrix){
        int mid;
        while(left < right){
            mid = (left+right)/2;
            if(matrix[row][mid] < key) left = mid+1;
            else right = mid;
        }
        return left;
    }
}
