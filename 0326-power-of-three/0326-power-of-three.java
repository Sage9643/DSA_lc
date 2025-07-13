class Solution {
    public boolean isPowerOfThree(int n) {
        int max=(int)Math.pow(3,19);//highest power of three within int range
        //if any number divides this completely then it is power of 3
        if(n>0 && max% n==0){
            return true;
        }return false;
    }
}