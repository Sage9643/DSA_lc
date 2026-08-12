class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();

        int i=0,j=0;
        int maxlen=0;

        while(j<nums.length){

            map.put(nums[j],map.getOrDefault(nums[j],0)+1);

            while(map.get(nums[j])>k){
                int el=nums[i];
                map.put(el,map.get(el)-1);
                i++;
            }
            maxlen=Math.max(maxlen,j-i+1);
            j++;
        }
        return maxlen;

    }
}