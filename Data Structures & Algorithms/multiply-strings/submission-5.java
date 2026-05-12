class Solution {
    public String multiply(String num1, String num2) {
        //early check
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        int[]res=new int[num1.length()+num2.length()];//res sz
        //rev both,indx 0 onesplace n indx 1 10splce
        num1=new StringBuilder(num1).reverse().toString();
        num2=new StringBuilder(num2).reverse().toString();
        //Nested loops = digit-by-digit multiplication
        //Multiply every digit of num1 with every digit of num2
        for(int i1=0;i1<num1.length();i1++){
            for(int i2=0;i2<num2.length();i2++){
                int digit=(num1.charAt(i1)-'0')*(num2.charAt(i2)-'0');
                res[i1+i2]+=digit;
                res[i1+i2+1]+=res[i1+i2]/10;
                res[i1+i2]%=10;
            }
        }
        StringBuilder result = new StringBuilder();
        //skip leading 0s actually arr is reversed here so trialing
        int i = res.length-1;
        while(i>=0 && res[i]==0){
            i--;
        }
        //Build answer from most significant digit
        while(i>=0){
            result.append(res[i--]);//backwards due to reversed
        }
        return result.toString();
    }
}