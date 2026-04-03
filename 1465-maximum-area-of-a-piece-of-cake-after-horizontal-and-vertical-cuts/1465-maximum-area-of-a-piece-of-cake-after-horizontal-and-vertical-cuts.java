class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        long maxh=verticalCuts[0];
        long maxw=horizontalCuts[0];

        for(int i=0;i<horizontalCuts.length-1;i++) maxw=Math.max(maxw,horizontalCuts[i+1]-horizontalCuts[i]);
        for(int i=0;i<verticalCuts.length-1;i++) maxh=Math.max(maxh,verticalCuts[i+1]-verticalCuts[i]);

        maxw=Math.max(maxw,h-horizontalCuts[horizontalCuts.length-1]);
        maxh=Math.max(maxh,w-verticalCuts[verticalCuts.length-1]);

        return (int)((maxh*maxw)%1000000007);
    }
}