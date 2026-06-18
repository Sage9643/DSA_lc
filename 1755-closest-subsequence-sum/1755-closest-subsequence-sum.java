class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        ArrayList<Integer> arr1=new ArrayList<>();
        ArrayList<Integer> arr2=new ArrayList<>();

        int half=nums.length/2;
        int rest=nums.length-half;

        for(int i=0;i<(1<<half);i++){
            int sum=0;
            for(int j=0;j<half;j++){
                if((i & (1<<j))!=0) sum+=nums[j];
            }
            arr1.add(sum);
        }
        for(int i=0;i<(1<<rest);i++){
            int sum=0;
            for(int j=0;j<rest;j++){
                if((i & (1<<j))!=0) sum+=nums[half+j];
            }
            arr2.add(sum);
        }
        Collections.sort(arr2);
        int min=Integer.MAX_VALUE;
        for(int a:arr1){
            int diff=goal-a;
            int gs[]=bs(arr2,diff);

            if(gs[0]!=-1) min=Math.min(min,Math.abs(a+arr2.get(gs[0])-goal));
            if(gs[1]!=-1) min=Math.min(min,Math.abs(a+arr2.get(gs[1])-goal));
        }
        return min;
    }public static int[] bs(ArrayList<Integer> arr,int val){
        int start=0,end=arr.size()-1;
        int idx=arr.size();
        while(start<=end){
            int mid=(start+end)/2;

            if(arr.get(mid)>=val){
                end=mid-1;
                idx=mid;
            }else start =mid+1;
        }
        int s=idx==0?-1:idx-1;
        int g=idx==arr.size()? -1:idx;

        return new int[]{g,s};
    }
}