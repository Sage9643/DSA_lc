class Solution {
    public int[] findErrorNums(int[] nums) {
        int count[]=new int[nums.length+1];
        count[0]=1;
        int res[]=new int[2];
        for(int i=0;i<nums.length;i++){
            count[nums[i]]++;
        }for(int i=1;i<count.length;i++){
            if(count[i]==2){
                res[0]=i;
            }if(count[i]==0){
                res[1]=i;
            }
        }return res;

    }
}