class Solution {
    public int maxScore(int[] cardPoints, int k) {
        long totsum=0;
        long minsum=Integer.MAX_VALUE;
        for(int c:cardPoints) totsum+=c;
        int len=cardPoints.length-k;
        if(len==0) return (int) totsum;
        long sum=0;int i=0;
        for(;i<len;i++) sum+=cardPoints[i];

        minsum=sum;
        while(i<cardPoints.length){
            sum=sum-cardPoints[i-len]+cardPoints[i];
            minsum=Math.min(minsum,sum);
            i++;   
        }return (int)(totsum-minsum);

    }
}