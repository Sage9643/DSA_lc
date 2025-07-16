class Solution {
    public int maximumLength(int[] nums) {
        if(nums.length==2){
            return 2;
        }int odds=0,evens=0,alternates=0,parity=0;
        for(int i=0;i<nums.length;i++){
            int currparity=nums[i]%2;
            if(i==0){
                parity=nums[0]%2;//checking if first element is odd or even
                alternates=1;
            }if(currparity!=parity){
                alternates++;
                parity=currparity;
            }
            if(nums[i]%2==0){
                evens++;
            }else{
                odds++;
            }
        }
        if(alternates>=odds && alternates>=evens ){
            return alternates;
        }else if(odds>=alternates && odds>=evens){
            return odds;
        }return evens;
        
    }
}