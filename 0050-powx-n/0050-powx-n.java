class Solution {
    public double myPow(double x, int n) {
        boolean expsign=(n<0)? false:true;
        long exp=Math.abs((long)n);
        boolean numsign=true;
        if(x<0){
            numsign=(exp%2==0)? true:false;
        }
        double num=Math.abs((double)x);
        double ans=1;
        while(exp!=0){
            if((exp & 1)!=0){
                ans*=num;
            }num*=num;
            exp=exp>>1;
        }if(!expsign && !numsign){
            return -(1/ans);
        }else if(expsign && !numsign){
            return - ans;
        }else if(!expsign && numsign){
            return 1/ans;
        }return ans;
    }
}