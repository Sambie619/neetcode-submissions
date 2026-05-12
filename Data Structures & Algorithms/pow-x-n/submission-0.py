class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n==0:
            return 1
        if n<0:
            x=1/x
            n=-n
        res=1
        while n:
            if n%2:
                res*=x  #if curr expo is odd mul res one time by x
            x*=x#Each loop, square the base →because when exponent halves, the base doubles in power.
            n//=2
        return res