class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            largest=Math.max(piles[i],largest);
        }int start=1;int end=largest;
        int mintime=Integer.MAX_VALUE;
        while(start<=end){
            int totalhrs=0;
            int mid=start+(end-start)/2;
            for(int i=0;i<piles.length;i++){
                totalhrs+=Math.ceil((double)piles[i]/mid);
            }if(totalhrs<=h){
                mintime=Math.min(mid,mintime);
                end=mid-1;
            }else{ 
                start=mid+1;
            }
        }return mintime;
    }
}