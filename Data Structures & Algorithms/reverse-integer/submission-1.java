class Solution {
    public int reverse(int x) {
        final int MIN=-2147483648;// -2^31
        final int MAX = 2147483647;  // 2^31 - 1
        int res =0;//storing rev res
        while(x != 0){
            int digit= x % 10;
            x /= 10;
            if(res > MAX/10 ||(res ==MAX/10 &&digit>MAX%10))
                return 0;
            //If res * 10 + digit would overflow the 32-bit signed integer range:
            if (res < MIN / 10 || (res == MIN / 10 && digit < MIN % 10))
                return 0;
            res = (res *10)+digit;
        }return res;
    }
}
