class Solution {
    public int climbStairs(int n, int[] costs) {
        int prev1=costs[0]+1;
        int prev2=Integer.MAX_VALUE;
        if(n==1) return prev1;
        if(n>=2){
            prev2=Math.min(costs[1]+4,costs[1]+1+prev1);
        }if(n==2) return prev2;
        int prev3=Integer.MAX_VALUE;
        if(n>=3){
            prev3=Math.min(costs[2]+9,Math.min(costs[2]+4+prev1,costs[2]+1+prev2));
        }if(n==3) return prev3;
        int prev4=Integer.MAX_VALUE;
        for(int i=3;i<costs.length;i++){
            prev4=Math.min(costs[i]+9+prev1,Math.min(costs[i]+4+prev2,costs[i]+1+prev3));
            prev1=prev2;
            prev2=prev3;
            prev3=prev4;
        }return prev3;
        
    }
}