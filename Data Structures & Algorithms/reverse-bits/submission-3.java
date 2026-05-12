class Solution {
    public int reverseBits(int n) {
        int res = 0;//to store res
        for(int i = 0;i< 32;i++){
            int bit = (n >> i)&1;//extra the rytmost bt
            res += (bit<<(31-i));//like move the 31th in 0th
            //and add 31 0s
        }
        return res;
    }
}
