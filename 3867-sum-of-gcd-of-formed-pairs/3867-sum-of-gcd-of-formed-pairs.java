class Solution {
    public long gcdSum(int[] nums) {
        int max[]=new int[nums.length];
        max[0]=nums[0];
        for(int i=1;i<nums.length;i++) max[i]=Math.max(nums[i],max[i-1]);

        int prefixgcd[]=new int[nums.length];

        for(int i=0;i<nums.length;i++) prefixgcd[i]=gcd(nums[i],max[i]);

        Arrays.sort(prefixgcd);

        long sum=0;

        for(int i=0;i<nums.length/2;i++){
            sum+=gcd(prefixgcd[i],prefixgcd[nums.length-1-i]);
        }return sum;
        
    }public static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}