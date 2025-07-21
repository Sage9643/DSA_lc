class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs,(row1,row2)->{
            int diff1=Math.abs(row1[1]-row1[0]);
            int diff2=Math.abs(row2[1]-row2[0]);

            if(diff1!=diff2){
                return Integer.compare(diff2,diff1);//for desc order if diff2>diff1 returns 1 which means swap
            }else{
                int sum1=row1[1]+row1[0];
                int sum2=row2[1]+row2[0];
                return Integer.compare(sum2,sum1);
            }});
        int cityA=costs.length/2,cityB=costs.length/2;
        int totalcost=0;
        for(int i=0;i<costs.length;i++){
            if(costs[i][0]>=costs[i][1] && cityB!=0){
                cityB--;
                totalcost+=costs[i][1];
            }else if(costs[i][0]<=costs[i][1] && cityA!=0){
                cityA--;
                totalcost+=costs[i][0];
            }else if(cityA==0){
                cityB--;
                totalcost+=costs[i][1];
            }else{
                cityA--;
                totalcost+=costs[i][0];
            }
        }return totalcost;
    }
}