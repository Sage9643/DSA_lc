class Solution {
    public boolean isPalindrome(int x) {
        if(x>=0){
            int newx=x;
            int rev=0;
            while(newx>0){
                rev=rev*10+(newx%10);
                newx/=10;
            }if(rev==x){
                return true;
            }else{
                return false;
            }
        }
        else{
            return false;
            }
    }
}