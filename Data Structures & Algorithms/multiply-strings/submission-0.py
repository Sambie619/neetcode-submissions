class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        if "0" in [num1,num2]:
            return "0"
        res=[0]*(len(num1)+len(num2))#mul res  contain atm m+n size array
        num1,num2=num1[::-1],num2[::-1]#rev both for mul to start from lsb
        for i1 in range(len(num1)):#to mul every ele of n1 with ever el of n2
            for i2 in range(len(num2)):
                digit=int(num1[i1])*int(num2[i2])#mul 2 digits
                res[i1+i2]+=digit#units place
                res[i1+i2+1]+=res[i1+i2]//10#if carr put it to next
                res[i1+i2]=res[i1+i2]%10#only single dig allowed 
        res,beg=res[::-1],0#rev res coz we stored in rev
        while beg<len(res) and res[beg]==0:#to skip leadin 0s
            beg+=1
        res=map(str,res[beg:])#ret an iterator str applied to each ele
        return "".join(res)#join the map obj like '2' '3' '4'




        