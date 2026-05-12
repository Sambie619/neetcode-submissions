class Solution {
    public double myPow(double x, int n) {
        if(x==0)return 0;
        if(n==0)return 1;
        double res=1;//store final 
        long power=Math.abs((long)n);//work with positive exponent
        while(power>0){
            if((power&1)==1){
                res*=x;//if pow is odd mul res by x
            }
            x*=x;//square the base
            power>>=1;//divide exp by 2
        }
        return n>=0?res:1/res;//if n -ve ret 1/res else res
    }
}
