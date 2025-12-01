class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long min=Long.MAX_VALUE,sum=0;
        for(int b:batteries){
            sum+=b;
            min=Math.min(min,b);
        }long start=min,end=sum/n;
        long ans=0;

        while(start<=end){
            long mid=start+(end-start)/2;
            if(possible(batteries,n,mid)){
                ans=mid;
                start=mid+1;
            }else end=mid-1;
        }return ans;
    }public boolean possible(int[] bat,int comp,long mid){
        long sum=0;long target=mid*comp;
        for(int b:bat){
            sum+=Math.min(b,mid);
            if(sum>=target) return true;
        }return false;
    }
}