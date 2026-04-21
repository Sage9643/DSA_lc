class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int ans=0;
        for(int num:nums){
            ans+=count(num,digit);
        }return ans;
    }public static int count(int num,int target){
        int cnt=0;
        char tar=(char)(target+'0');
        for(char ch:Integer.toString(num).toCharArray()){
            if(ch==tar) cnt++;
        }return cnt;
            
        
    }
}