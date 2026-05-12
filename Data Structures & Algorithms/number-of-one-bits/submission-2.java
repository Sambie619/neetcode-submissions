class Solution {
    public int hammingWeight(int n) {
        int res=0;//counter
        while(n!=0){
            //we're & lsb with 1 to knowif its  1
            res += (n&1)==1?1:0;
            n >>= 1;//shift right for next lsb
        }
        return res;
    }
}
