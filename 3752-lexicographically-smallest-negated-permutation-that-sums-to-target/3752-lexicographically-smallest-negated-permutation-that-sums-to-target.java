class Solution {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        int ans[]=new int[n];
        long totsum= ((long)n*(n+1))/2;
        long diff=(totsum-target)/2;
        int idx=0;
        if(totsum<target || (totsum*(-1))>target) return new int[]{};
        if((totsum-target)%2!=0 ) return new int[]{};
        int rev=ans.length-1;

        for(int i=n;i>0;i--){
            if(diff>=i) {ans[idx++]=(-1)*i;diff-=i;}
            else {ans[rev]=i;rev--;}
            
        }return ans;
        
    }
}