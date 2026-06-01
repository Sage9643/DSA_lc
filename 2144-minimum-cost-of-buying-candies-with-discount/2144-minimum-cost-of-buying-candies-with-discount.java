class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int price=0;

        int idx=1;
        for(int i=cost.length-1;i>=0;i--){
            if(idx%3!=0){
                price+=cost[i];
            }idx++;
        }return price;
    }
}