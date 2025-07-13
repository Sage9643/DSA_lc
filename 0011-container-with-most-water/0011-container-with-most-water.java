class Solution {
    public int maxArea(int[] height) {
        //two pointer approach
        int leftbar=0;int rightbar=height.length-1;
        int maxwater=0;
        while(leftbar<rightbar){
            int width=(int)Math.abs(leftbar-rightbar);
            int waterheight=Math.min(height[leftbar],height[rightbar]);
            int currwater=width*waterheight;
            maxwater=Math.max(maxwater,currwater);
            if(height[leftbar]>height[rightbar]){
                rightbar--;
            }else{
                leftbar++;
            }
        }return maxwater;
    }
}