class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length%k!=0) return false;
        HashMap<Integer,Integer> map=new HashMap<>();
        Arrays.sort(nums);

        for(int num:nums) map.put(num,map.getOrDefault(num,0)+1);
        int i=0;
        while(i<nums.length){
            if(map.containsKey(nums[i])){
                int num=nums[i];
                int cnt=0;
                while(cnt<k){
                    if(map.containsKey(num)){
                        cnt++;map.put(num,map.get(num)-1);
                        if(map.get(num)==0) map.remove(num);
                        num++;
                    }else return false;
                }
            }i++;
            
        }return true;
    }
}