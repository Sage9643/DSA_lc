class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int grps=weights.length-days-1;int weight=0;int i=0;int minCapacity=Integer.MAX_VALUE;
        if(grps<1) grps=1;
        for(;i<grps;i++){
            weight+=weights[i];
            minCapacity=Math.min(minCapacity,weights[weights.length-1-i]);
        }int maxCapacity=weight;

        while(i<weights.length){
            weight+=weights[i]-weights[i-grps];
            maxCapacity=Math.max(maxCapacity,weight);
            minCapacity=Math.min(minCapacity,weights[i-grps]);
            i++;
        }int maxWeight=0,sum=0;
        for(int w:weights) {
            maxWeight=Math.max(maxWeight,w);
            sum+=w;
        }
        minCapacity = Math.max(minCapacity, maxWeight);
        maxCapacity = Math.max(maxCapacity, sum);


        int start=minCapacity,end=maxCapacity;
        int ans=Integer.MAX_VALUE;

        while(start<=end){
            int capacity=start+(end-start)/2;
            int time=dayCount(capacity,weights);
            if(time<=days){
                end=capacity-1;
                ans=capacity;
            }else start=capacity+1;

        }return ans;

    }
    public static int dayCount(int capacity,int[] weights){
        int wt=0;int days=1;
        for(int i=0;i<weights.length;i++){
            if((wt+weights[i])<=capacity) wt+=weights[i];
            else{
                days++;wt=weights[i];
            }
        }return days;
    }
}