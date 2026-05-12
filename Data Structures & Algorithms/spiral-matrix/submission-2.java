class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        //right = number of columns,bottom = number of rows
        int left = 0, right = matrix[0].length;
        int top = 0, bottom = matrix.length;
        //While there is still an unvisited rectangle
        while(left<right && top<bottom){
            for(int i=left;i<right;i++){//tra top row
                res.add(matrix[top][i]);
            }top++;
            //tra ryt col
            for (int i = top; i < bottom; i++) {
                res.add(matrix[i][right - 1]);
            }
            right--;
            //If the remaining rectangle is invalid,
            // break (prevents duplicates).
            if(!(left<right && top<bottom)){
                break;
            }
            //tra bot row
            for (int i = right - 1; i >= left; i--) {
                res.add(matrix[bottom - 1][i]);
            }
            bottom--;
            //tra left col
            for (int i = bottom - 1; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;//trigger either when top==bott/left==ryt
    }
}
