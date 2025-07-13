class Solution {
    public int mostFrequent(int[] nums, int key) {//using counting sort logic
        int count[]=new int[1001];
        for (int i=0;i<nums.length-1;i++){
            if(nums[i]==key){
                count[nums[i+1]]++;
            }
        }int ans=0;
        int max=0;
        for(int i=0;i<count.length;i++){
            if(count[i]>max){
                max=count[i];
                ans=i;
            }
        }return ans;
    }
}