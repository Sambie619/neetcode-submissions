class Solution {
    public int maxProfit(int[] prices) {
        int sold=Integer.MIN_VALUE;
        int held=Integer.MIN_VALUE;
        int reset=0;
        for(int p:prices){
            int prevSold=sold;
            sold=held+p;//selling at hold+cur
            held=Math.max(held,reset-p);//means i ws at reset,i bout at price p
            reset=Math.max(reset,prevSold);
        }
        return Math.max(sold,reset);
    }
}
//tc:o(n),sc:o(1)