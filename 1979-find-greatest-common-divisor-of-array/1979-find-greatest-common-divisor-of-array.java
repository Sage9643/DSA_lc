class Solution {
    public int findGCD(int[] nums) {
        int max=0,min=10000;
        for(int num:nums){
            min=Math.min(min,num);
            max=Math.max(max,num);
        }

        return gcd(max,min);
    }
    public static int gcd(int a ,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return Math.abs(a);
    }
}