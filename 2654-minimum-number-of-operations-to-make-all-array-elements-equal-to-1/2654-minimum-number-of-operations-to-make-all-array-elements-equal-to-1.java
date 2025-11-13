class Solution {
    public int minOperations(int[] nums) {
        int cnt1=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1) cnt1++;
        }if(cnt1>0) return nums.length-cnt1;
        int op=Integer.MAX_VALUE; 
        for(int i=0;i<nums.length-1;i++){
            int gcd=nums[i];int turns=0;
            for(int j=i+1;j<nums.length;j++){
                gcd=gcd1(gcd,nums[j]);turns++;
                if(gcd==1){
                    op=Math.min(op,turns);break;
                }
            }   
        }if(op==Integer.MAX_VALUE) return -1;
        return op+nums.length-1;
    }
    public static int gcd1(int a,int b){
        if(Math.abs(a-b)==1) return 1;
        int small=Math.min(a,b);
        for(int i=small;i>1;i--){
            if(a%i==0 && b%i==0) return i;
        }return 1;
    }
}