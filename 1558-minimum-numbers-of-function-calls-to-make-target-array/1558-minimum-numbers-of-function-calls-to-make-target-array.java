class Solution {
    public int minOperations(int[] nums) {
        int cnt=0;
        boolean incomplete=true;

        while(incomplete){
            int cntzero=0;
            int i=0;
            for(;i<nums.length;i++){
                if(nums[i]==0) cntzero++;
                else if((nums[i]&1)==1) break;
            }
            if(cntzero==nums.length){
                incomplete=false;
                return cnt;
            }

            //all even
            if(i==nums.length){
                cnt++;
                for(int j=0;j<nums.length;j++) nums[j]/=2;
            }
            //odd encountered;
            else{
                for(int j=i;j<nums.length;j++){
                    if(nums[j]%2!=0){
                        cnt++;nums[j]--;
                    }
                }
            }
            

        }return cnt;
    }
}