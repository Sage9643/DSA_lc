class Solution {
    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        long hp=1,vp=1;
        long cost=0;
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);

        int i=horizontalCut.length-1;
        int j=verticalCut.length-1;

        while(i>=0 && j>=0){
            if(horizontalCut[i]>verticalCut[j]){
                cost+=(vp*horizontalCut[i]);
                hp++;
                i--;
            }else{
                cost+=(hp*verticalCut[j]);
                vp++;
                j--;
            }
        }while(i>=0){
            cost+=(vp*horizontalCut[i]);
            hp*=2;
            i--;
        }while(j>=0){
            cost+=(hp*verticalCut[j]);
            vp*=2;
            j--;
        }return cost;
    }
}