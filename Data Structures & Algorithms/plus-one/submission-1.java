class Solution {
    public int[] plusOne(int[] digits) {
        //Example: digits = [1, 2, 9]
        int n=digits.length;
        //Start from the last digit (least significant digit)
        for(int i=n-1;i>=0;i--){
            //If current digit is less than 9
            // we can simply add 1 and finish
        if(digits[i]<9){
            digits[i]++;
            return digits;
        }
        // If digit is 9, adding 1 makes it 0
            // and we carry 1 to the next digit
            // digits = [1, 2, 9]
            // i = 2 → digits[2] = 9 → becomes 0
        digits[i]=0;
        }
        // If we reach here, all digits were 9
        // Example: [9, 9, 9]
        // After loop → [0, 0, 0]
        // Create a new array with one extra digit
        int[]res=new int[n+1];
        // Set the first digit to 1
        res[0]=1;
        return res;

    }
}
