class Solution {
    public boolean isHappy(int n) {
       // slow moves 1 step at a time
        // fast moves 2 steps at a time
        // (Floyd’s cycle detection, like tortoise & hare)
        int slow=n;// slow = 19
        int fast=sumOfSquares(n);//fast = sumOfSquares(19)1² + 9² = 82
        // fast moves TWO steps
        while(slow!=fast){
            // fast moves TWO steps
            fast=sumOfSquares(fast);//fast = sumOfSquares(82)8² + 2² = 68
            fast=sumOfSquares(fast);//fast = sumOfSquares(68)6² + 8² = 100
            // slow moves ONE step
            slow=sumOfSquares(slow);}//slow = sumOfSquares(19)= 82
            // If they meet at 1 → Happy Number
            // Otherwise they met in a cycle → Not Happy
            return fast==1;
         
    }
    // Helper function:
    // Break number into digits and add squares of digits
    private int sumOfSquares(int n){
        int output=0;
        while(n!=0){
            int digit=n%10;//get last digit
            output+=digit*digit;//add sqrs of dig
            n/=10;
        }return output;
    }
}
