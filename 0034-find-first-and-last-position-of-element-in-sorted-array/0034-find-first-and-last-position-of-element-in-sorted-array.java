class Solution {
    public int[] searchRange(int[] nums, int val) {
        int idx=-1;
        int ans[]={-1,-1};
        int start=0,end=nums.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==val){
                idx=mid;
                break;
            }else if(val>nums[mid]){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }if(idx!=-1){//here a number can occur multiple times thatswhy we have to around the index for any occurence of val
            int orgidx=idx;
            ans[0]=idx;ans[1]=idx;
            if(idx>0 && nums[idx-1]==val){
                while(idx>0 && nums[idx-1]==val){
                    idx--;
                }ans[0]=idx;
            }if(orgidx<nums.length-1 && nums[orgidx+1]==val){
                while(orgidx<nums.length-1 && nums[orgidx+1]==val){
                    orgidx++;
                }
                ans[1]=orgidx;
            }
        }return ans;
    }
}