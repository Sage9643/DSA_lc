class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> remainder=new HashMap<>();
        remainder.put(0,-1);
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int rem=sum%k;
            if(!remainder.containsKey(rem)) remainder.put(rem,i);
            else{
                if((i-remainder.get(rem))>1) return true;
            }
        }return false;
    }
}