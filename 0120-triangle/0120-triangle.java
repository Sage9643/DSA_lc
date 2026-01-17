class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int dp[][]=new int[triangle.size()][triangle.get(triangle.size()-1).size()];

        for(int i=0;i<triangle.size();i++){
            for(int j=0;j<triangle.get(i).size();j++){
                if(i==0 && j==0) dp[i][j]=triangle.get(0).get(0);
                else{
                    if(i>0 && j<triangle.get(i).size()-1 && j>0) dp[i][j]=Math.min(dp[i-1][j-1],dp[i-1][j])+triangle.get(i).get(j);
                    else if(i>0 && j>0) dp[i][j]=dp[i-1][j-1]+triangle.get(i).get(j);
                    else dp[i][j]=dp[i-1][j]+triangle.get(i).get(j);
                }
            }
        }int minsum=Integer.MAX_VALUE;
        for(int i=0;i<triangle.get(triangle.size()-1).size();i++){
            minsum=Math.min(minsum,dp[triangle.size()-1][i]);
        }return minsum;

    }
}