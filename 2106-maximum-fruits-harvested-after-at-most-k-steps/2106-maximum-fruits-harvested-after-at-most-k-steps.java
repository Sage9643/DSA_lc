class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int sum=0;
        int maxFruit=0;
        int left=0;

        for(int right=0;right<fruits.length;right++){
            sum+=fruits[right][1];

            while(left<=right && minSteps(fruits[left][0],fruits[right][0],startPos)>k){
                sum-=fruits[left][1];
                left++;
            }maxFruit=Math.max(sum,maxFruit);
        }return maxFruit;
    }    
    public int minSteps(int left,int right,int startPos){
        return Math.min(Math.abs(startPos-left)+right-left,Math.abs(startPos-right)+right-left);
    }
}