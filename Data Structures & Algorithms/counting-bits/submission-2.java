class Solution {
    public int[] countBits(int n) {
        int[]res=new int[n+1];//for 0 ... 3 if n=3
        for(int i=1;i<=n;i++){
            int num =i;//extracting to num
            //from 1 .. n
            while(num!=0){
                res[i]++;//increase 1 for each 'num'
                num &= (num-1);//for vanishing the lowest setbit
            }
        }return res;
    }
}
