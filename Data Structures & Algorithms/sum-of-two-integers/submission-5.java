class Solution {
    public int getSum(int a, int b) {
        //b is carry,+=^  <<carry
        while(b!=0){
            int carry = (a&b)<<1;
            a ^= b;
            b = carry;
        }return a;
    }
}//we stop when carry is 0 ryt
