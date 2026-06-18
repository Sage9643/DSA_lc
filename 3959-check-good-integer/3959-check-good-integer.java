class Solution {
    public boolean checkGoodInteger(int n) {
        int digsum=0;
        int sqsum=0;

        while(n!=0){
            int rem=n%10;
            digsum+=rem;
            sqsum+=(rem*rem);
            n/=10;
        }
        return sqsum-digsum>=50;
    }
}