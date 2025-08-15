class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        HashMap<Integer,Integer> uniq=new HashMap<>();
        int i=0,j=-1;
        long currSum=0;
        long maxSum=0;
        for(int l=0;l<k;l++){
            currSum+=nums.get(l);
            uniq.put(nums.get(l),uniq.getOrDefault(nums.get(l),0)+1);
            j++;
        }
        while(j<nums.size()-1){
            if(uniq.size()>=m && j-i==k-1){
                maxSum=Math.max(maxSum,currSum);
            }currSum-=nums.get(i);
            uniq.put(nums.get(i),uniq.get(nums.get(i))-1);
            if(uniq.get(nums.get(i))==0) uniq.remove(nums.get(i));
            i++;j++;
            uniq.put(nums.get(j),uniq.getOrDefault(nums.get(j),0)+1);
            currSum+=nums.get(j);
        }if(uniq.size()>=m && j-i==k-1){
                maxSum=Math.max(maxSum,currSum);
        }
        return maxSum;
    }
}