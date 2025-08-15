class Solution {
    public boolean isPowerOfFour(int n) {
        double num=n;
        while(num>1){
            num=(double)num/4;
        }if(num==1)return true;
        return false;
    }
}