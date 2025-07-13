class Solution {
    public int mySqrt(int x) {
        int ans=0;
        if(x==1 || x==0){
            return x;
        }
        for(int i=1;i<=x/i;i++){
            ans=i;
        }return ans;   
    }
}