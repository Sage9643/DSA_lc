class Solution {
    public int minOperations(int n) {
        int l=n/2;
        if(n%2!=0) return 2*((l*(l+1))/2);
        
        return (int) Math.pow(l,2);
    }
}