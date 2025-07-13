class Solution {
    public int maxProfit(int[] price) {
        int profit=0;
        int sell=0;
        int buy=Integer.MAX_VALUE;
        for(int i=0;i<price.length-1;i++){
            if(buy>price[i]){
                buy=price[i];
            }sell=price[i+1];
            if(sell>buy && profit<(sell-buy)){
                profit=sell-buy;
            }
        }return profit;
    }
}