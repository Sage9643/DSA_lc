class Solution {
    public int trap(int[] height) {
        /*int waterlevel[]=new int[height.length];
        int lmax[]=new int[height.length];
        int rmax[]=new int[height.length];
        for(int i=0;i<height.length;i++){
            if(i==0){
                lmax[i]=height[i];
            }else{
                if(lmax[i-1]<height[i]){
                    lmax[i]=height[i];
                }else{lmax[i]=lmax[i-1];}
            }
        }
        for(int i=height.length-1;i>=0;i--){
            if(i==height.length-1){
                rmax[i]=height[i];
            }else{
                if(rmax[i+1]<height[i]){
                    rmax[i]=height[i];
                }else{
                    rmax[i]=rmax[i+1];
                }
            }
        }for(int i=0;i<height.length;i++){
            waterlevel[i]=Math.min(rmax[i],lmax[i]);
        }int trappedwater=0;
        for(int i=0;i<height.length;i++){
            trappedwater+=(waterlevel[i]-height[i]);
        }return trappedwater;
        */
        int leftBoundary=0;
        int rightBoundary=height.length-1;
        int leftmax=0,rightmax=0;
        int waterTrapped=0;
        while(leftBoundary<rightBoundary){
            leftmax=Math.max(leftmax,height[leftBoundary]);
            rightmax=Math.max(rightmax,height[rightBoundary]);
            if(leftmax<rightmax){
                waterTrapped+=leftmax-height[leftBoundary];
                leftBoundary++;
            }else{
                waterTrapped+=rightmax-height[rightBoundary];
                rightBoundary--;
            }
        }return waterTrapped;
    }
}