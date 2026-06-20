class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        int m=restrictions.length;

        if(m==0) return n-1;
        
        Arrays.sort(restrictions,(a,b)->a[0]-b[0]);

        int isLast=restrictions[m-1][0]==n? 0:1;
        int h[][]=new int[m+1+isLast][2];

        h[0][0]=1;
        h[0][1]=0;

        for(int i=0;i<m;i++){
            int diff=restrictions[i][0]-h[i][0];

            h[i+1][0]=restrictions[i][0];
            h[i+1][1]=Math.min(restrictions[i][1],h[i][1]+diff);
        }
        if(isLast==1){
            int diff=n-restrictions[m-1][0];
            h[h.length-1][0]=n;
            h[h.length-1][1]=Math.min(n-1,h[h.length-2][1]+diff);
        }

        for(int i=h.length-2;i>=0;i--){
            int diff=h[i+1][0]-h[i][0];
            h[i][1]=Math.min(h[i][1],h[i+1][1]+diff);
        }

        int max=0;
        for(int i=0;i<h.length-1;i++){
            int rt=h[i+1][0];
            int lt=h[i][0];
            int h1=h[i+1][1];
            int h2=h[i][1];

            max=Math.max(max,(rt-lt-Math.abs(h1-h2))/2+Math.max(h1,h2));
        }return max;
    }
}