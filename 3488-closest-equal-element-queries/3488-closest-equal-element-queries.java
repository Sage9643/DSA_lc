class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n=nums.length;
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();

        for(int i=0;i<n;i++){
            if(!map.containsKey(nums[i])) map.put(nums[i],new ArrayList<>());
            map.get(nums[i]).add(i-n);
        }for(int i=0;i<n;i++){
            int prev=map.get(nums[i]).get(map.get(nums[i]).size()-1);
            if(i-prev!=n) map.get(nums[i]).add(i);
        }for(int i=0;i<n;i++){
            int prev=map.get(nums[i]).get(map.get(nums[i]).size()-1);
            if(i-prev!=n) map.get(nums[i]).add(n+i);
        }
        List<Integer> ans=new ArrayList<>();
        
        for(int q:queries){
            int el=nums[q];
            ArrayList<Integer> arr=map.get(el);
            if(arr.size()==1) ans.add(-1);
            else{
                int idx=bs(arr,q);
                ans.add(Math.min(arr.get(idx)-arr.get(idx-1),arr.get(idx+1)-arr.get(idx)));
            }
            
        }
        return ans;

    }public static int bs(ArrayList<Integer> arr,int tar){
        int start=0,end=arr.size()-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr.get(mid)==tar) return mid;
            else if(arr.get(mid)>tar) end=mid-1;
            else start=mid+1;
        }return -1;
    }
}