class Solution {
    public int maxDistToClosest(int[] seats) {
        int j=0;int i=0;int dist=0;
        while(seats[i]!=1) i++;
        dist=i-0;j=i;i++;
        for(;i<seats.length;i++){
            if(seats[i]==1){
                dist=Math.max(dist,(i-j)/2);
                j=i;
            }
        }if(dist<seats.length-1-j)dist=seats.length-1-j;
        return dist;
    }
}