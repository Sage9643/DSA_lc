class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {    
        for (int i=0;i+2*k<=nums.size();i++) {
            boolean first=true,second=true;

            // checking if first subarray is inc
            for (int j=i+1;j<i+k;j++){
                if (nums.get(j)<=nums.get(j-1)){
                    first=false;
                    break;
                }
            }// checking if second subarray is inc
            for (int j=i+k+1;j<i+2*k;j++){
                if(nums.get(j)<=nums.get(j-1)){
                    second=false;
                    break;
                }
            }if (first && second) return true;
        }
        return false;
    }
}
