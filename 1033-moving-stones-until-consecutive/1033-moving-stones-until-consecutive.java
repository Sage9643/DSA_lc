class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int max=0,mid=0,min=0;
        //max
        if(a>b && a>c) max=a;
        else if(b>c && b>a) max=b;
        else max=c;

        //min
        if(a>b && c>b) min=b;
        else if(b>a && c>a) min=a;
        else min=c;

        //mid
        if((max==a || max==b) && (min==a || min==b)) mid=c;
        else if((max==a || max==c) && (min==a || min==c)) mid=b;
        else mid=a;

        int diff1=mid-min;
        int diff2=max-mid;

        if(diff1==1 && diff2==1) return new int[]{0,0};
        if(diff1==1 || diff2==1){
            int maxstep=0;
            if(diff1==1) maxstep=max-mid-1;
            else maxstep=mid-min-1;

            return new int[]{1,maxstep};
        }if(diff1==2 || diff2==2){
            int maxstep=0;
            if(diff1==2) maxstep=max-mid;
            else maxstep=mid-min;
            return new int[]{1,maxstep};
        }return new int[]{2,diff1+diff2-2};
    }
}