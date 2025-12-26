class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k>bloomDay.length) return -1;
        int min=Integer.MAX_VALUE,max=0;

        for(int num:bloomDay){
            min=Math.min(min,num);
            max=Math.max(max,num);
        }int minday=max;
        int start=min,end=max;
        while(start<=end){
            int mid=(start+end)/2;

            if(possible(bloomDay,mid,m,k)){
                minday=mid;end=mid-1;
            }else start=mid+1;
        }return minday;
    }private static boolean possible(int[]b,int day,int m,int k){
        int nob=0;int cnt=0;

        for(int i=0;i<b.length;i++){
            if(b[i]<=day) cnt++;
            else{
                nob+=(cnt/k);
                cnt=0;
            }
        }nob+=(cnt/k);
        if(nob>=m) return true;
        return false;
    }
}