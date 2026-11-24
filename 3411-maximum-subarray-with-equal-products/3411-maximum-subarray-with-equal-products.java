class Solution {
    public int maxLength(int[] nums) {
        int n=nums.length;
        int l=0,ans=Math.min(n, 2);

        while(l<n){
            int r=l;
            while(r<n){
                boolean ok=true;
                for(int i=l;i<r;i++){
                    if(gcd(nums[i],nums[r])>1){
                        ok=false;
                        break;
                    }
                }if(!ok) break;
                ans=Math.max(ans,r-l+1);
                r++;
            }l++;
        }
        return ans;
    }

    public static int gcd(int a,int b) {
        while(b!=0) {
            int t=a%b;
            a=b;
            b=t;
        }return a;
    }
}