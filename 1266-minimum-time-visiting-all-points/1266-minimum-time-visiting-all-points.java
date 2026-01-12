class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int tot=0;
        int x1=points[0][0];
        int y1=points[0][1];

        for(int i=1;i<points.length;i++){
            int x2=points[i][0];
            int y2=points[i][1];

            if(Math.abs(x1-x2)>Math.abs(y1-y2)){
                int diff=Math.abs(y1-y2);
                tot+=diff+(Math.abs(x1-x2)-diff);
            }else{
                int diff=Math.abs(x1-x2);
                tot+=diff+(Math.abs(y1-y2)-diff);
            }x1=x2;y1=y2;
        }return tot;
    }
}