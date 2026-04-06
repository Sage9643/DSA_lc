class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            int lcm=1;
            for(int j=i;j<nums.length;j++){
                if(nums[j]>=lcm && nums[j]%lcm==0) lcm=nums[j];
                else if(lcm%nums[j]!=0) lcm=(lcm/gcd(lcm,nums[j]))*nums[j];
                
                if(lcm>k) break;
                else if(lcm==k) cnt++;
            }
        }return cnt;
    }public static int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }return a;
    }
}