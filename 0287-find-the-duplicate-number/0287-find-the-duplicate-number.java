class Solution {
    public int findDuplicate(int[] nums) {
        int result=0;
        for(int bits=0;bits<32;bits++){//traversing through all 32 bits
            int countbitrange=0;//number of 1 in ith bit from 1 to n
            int countbitnums=0;//number of 1 in ith bit in elements of nums array
            for(int element=0;element<nums.length;element++){
                if((nums[element]&(1<<bits)) !=0){
                    countbitnums++;
                }
            }for(int number=1;number<nums.length;number++){
                if((number&(1<<bits)) !=0){
                    countbitrange++;
                }
            }if(countbitnums>countbitrange){
                result|=(1<<bits);
            }
        }return result;
    }
}