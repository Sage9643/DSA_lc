class Solution {
    public int minimumDifference(int[] nums) {
        int n=nums.length/2;
        long tot=0;

        for(int num:nums) tot+=num;
        long half=tot/2;

        ArrayList<Long> arr1[]=new ArrayList[n+1];
        ArrayList<Long> arr2[]=new ArrayList[n+1];

        for(int i=0;i<=n;i++){
            arr1[i]=new ArrayList<>();
            arr2[i]=new ArrayList<>();
        }

        for(int i=0;i<(1<<n);i++){
            int el=0;
            long sum1=0;
            long sum2=0;
            for(int j=0;j<n;j++){
                if((i & (1<<j))!=0){
                    sum1+=nums[j];
                    sum2+=nums[n+j];
                    el++;
                }
            }arr1[el].add(sum1);
            arr2[el].add(sum2);
        }
        for(int i=0;i<=n;i++){
            Collections.sort(arr2[i]);
        }
        int min=Integer.MAX_VALUE;

        for(int i=0;i<=n;i++){
            ArrayList<Long> p1=arr1[i];
            ArrayList<Long> p2=arr2[n-i];


            for(long a:p1){
                long diff=half-a;
                int gs[]=bs(p2,diff);

                if(gs[0]!=-1) min=Math.min(min,(int)Math.abs(tot-(2*(a+p2.get(gs[0])))));
                if(gs[1]!=-1) min=Math.min(min,(int)Math.abs(tot-(2*(a+p2.get(gs[1])))));

            }
        }
        return min;    
    }
    public static int[] bs(ArrayList<Long> arr,long diff){
        int start=0,end=arr.size()-1;
        int idx=arr.size();

        while(start<=end){
            int mid=(start+end)/2;

            if(arr.get(mid)>=diff){
                end=mid-1;
                idx=mid;
            }else start=mid+1;
        }
        int s=idx==0? -1:idx-1;
        int g=idx==arr.size()? -1:idx;

        return new int[]{g,s};
    }
}