class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n=nums.size();
        int pref[]=new int[n];

        pref[0]=nums.get(0);

        for(int i=1;i<n;i++) pref[i]=pref[i-1]+nums.get(i);

        int minsum=Integer.MAX_VALUE;

        for(int i=l-1;i<n;i++){
            int sum=pref[i];
            if(i-r<0){
                if(sum>0) minsum=Math.min(minsum,sum);
            }
            if(i>=l){
                int j=i-l;
                while(j>=i-r && j>=0){
                    int temp=sum-pref[j];
                    if(temp>0) minsum=Math.min(minsum,temp);
                    j--;
                }
            }   
        }
        if(minsum==Integer.MAX_VALUE) return -1;
        return minsum;


    }
}