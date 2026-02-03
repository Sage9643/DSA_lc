class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int totarea=((ax2-ax1)*(ay2-ay1))+((bx2-bx1)*(by2-by1));

        int x[]={ax1,ax2,bx1,bx2};
        int y[]={ay1,ay2,by1,by2};

        Arrays.sort(x);
        Arrays.sort(y);

        if((x[0]==ax1 && x[1]==ax2) || (x[0]==bx1 && x[1]==bx2) || (y[0]==ay1 && y[1]==ay2) || y[0]==by1 && y[1]==by2) return totarea;

        int overlaparea=((x[2]-x[1])*(y[2]-y[1]));

        return totarea-overlaparea;
    }
}