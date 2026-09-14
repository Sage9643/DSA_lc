class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1=rec2[0],x2=rec2[2];
        int y1=rec2[1],y2=rec2[3];

        if(x1>=rec1[2] || x2<=rec1[0]) return false;
        if(y1>=rec1[3] || y2<=rec1[1]) return false;

        return true;

    }
}