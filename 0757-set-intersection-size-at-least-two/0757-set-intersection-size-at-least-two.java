class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[1]==b[1]) return b[0]-a[0];
            return a[1]-b[1];
        });

        int count=0;
        int p1=-1;
        int p2=-1;

        for(int i=0;i<intervals.length;i++){
            if(p2<intervals[i][0]){
                count+=2;
                p1=intervals[i][1]-1;
                p2=intervals[i][1];
            }if(p1<intervals[i][0]){
                p1=p2;
                p2=intervals[i][1];
                count+=1;
            }
        }return count;
    }
}