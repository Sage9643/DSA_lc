class Solution {
    public int minCost(int n) {
        int mincost=0;
        while(n>=2){
            mincost+=(n-1);
            n--;
        }return mincost;
    }
}