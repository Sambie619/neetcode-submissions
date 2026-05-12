class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xorr = n;//3 for [1,2,3]   [0,3]
        //xor each n in arr with 0 ... n leaving the missin
        for(int i = 0;i < n;i++){
            xorr^=i^nums[i];//xor cancels out same nums
        }
        return xorr;
    }
}
