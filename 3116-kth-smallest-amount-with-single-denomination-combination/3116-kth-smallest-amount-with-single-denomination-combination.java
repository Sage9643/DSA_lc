class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long start=1,end=1;

        int min=Integer.MAX_VALUE;
        for(int c:coins) min=Math.min(min,c);
        end=1L*k*min;

        long ans=0;

        while(start<=end){
            long mid=start+(end-start)/2;

            if(count(mid,coins)>=k){
                ans=mid;
                end=mid-1;
            }else start=mid+1;
        }
        return ans;
    }
    public static long count(long x,int coins[]){

        long ans=0;

        for(int i=1;i<(1<<coins.length);i++){
            ArrayList<Integer> subseq=new ArrayList<>();

            for(int j=0;j<coins.length;j++){
                if((i & (1<<j))!=0) subseq.add(coins[j]);
            }
            long lcm=getLCM(subseq,x);
            if(lcm>x) continue;
            long ways=x/lcm;

            if(subseq.size()%2==0) ans-=ways;
            else ans+=ways;
        }
        return ans;
    }
    public static long getLCM(ArrayList<Integer> arr,long x){
        long lcm=1;

        for(int a:arr){
            lcm=LCM(lcm,a);

            if(lcm>x) return lcm;
        }
        return lcm;

    }
    public static long LCM(long a,long b){
        return (a/gcd(a,b))*b;
    }
    public static long gcd(long a,long b){
        while(b!=0){
            long temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}