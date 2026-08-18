class Solution {
    public int largestInteger(int[] nums, int k) {

        
        if(k==nums.length){
            int max=0;
            for(int n:nums) max=Math.max(max,n);
            return max;
        }
        if(k==1 ||k==nums.length){
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int n:nums) map.put(n,map.getOrDefault(n,0)+1);

            int max=-1;
            for(int key:map.keySet()){
                int f=map.get(key);
                if(f==1) max=Math.max(max,key);
            }
            return max;
        }if(nums[0]==nums[nums.length-1]) return -1;

        
        
        HashSet<Integer> set=new HashSet<>();
        for(int i=1;i<nums.length-1;i++) set.add(nums[i]);

        int ans=-1;
        if(!set.contains(nums[0])) ans=nums[0];
        if(!set.contains(nums[nums.length-1])) ans=Math.max(nums[nums.length-1],ans);

        return ans;

    }
}