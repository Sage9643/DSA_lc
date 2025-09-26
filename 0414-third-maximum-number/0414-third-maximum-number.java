class Solution {
    public int thirdMax(int[] nums) {
        long first=Long.MIN_VALUE;
        long second=Long.MIN_VALUE;
        long third=Long.MIN_VALUE;

        for(int num:nums){
            if(first<num && first!=num){
                third=second;
                second=first;
                first=num;
            }else if(second<num && second!=num && first!=num){
                third=second;
                second=num;
            }else if(third<num && first!=num && second!=num) third=num;
        }return(third==Long.MIN_VALUE)?(int)first:(int)third;
        
    }
}