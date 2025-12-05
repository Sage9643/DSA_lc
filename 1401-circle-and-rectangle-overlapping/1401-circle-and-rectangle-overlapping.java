class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int px=Math.min(Math.max(xCenter,x1),x2);
        int py=Math.min(Math.max(yCenter,y1),y2);

        int dist=((xCenter-px)*(xCenter-px))+((yCenter-py)*(yCenter-py));
        if(dist<=(radius*radius)) return true;

        return false;
    }
}