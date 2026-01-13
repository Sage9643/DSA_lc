class Solution {
    public double separateSquares(int[][] squares) {
        double start=0,end=0;
        double totarea=0;
        for(int pt[]:squares) {
            end=Math.max(end,pt[1]+pt[2]);
            totarea+=((double)pt[2]*pt[2]);
        }
        double y=0;
        while((end-start)>1e-5){
            double mid=start+(end-start)/2;

            if(2*botarea(squares,mid)>=totarea){
                y=mid;
                end=mid;
            }else start=mid;
        }return y;

    }public static double botarea(int[][]squares,double mid){
        double bottomarea=0;
        for(int pt[]:squares){
            int side=pt[2];
            double height=Math.min(side,Math.max(0,mid-pt[1]));

            bottomarea+=(side*height);
        }return bottomarea;
    }
}