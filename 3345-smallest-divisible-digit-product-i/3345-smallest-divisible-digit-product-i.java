class Solution {
    public int smallestNumber(int n, int t) {
        int ans=Math.max(n,t);

        while(true){
            int prod=1;
            int num=ans;
            while(num!=0){
                prod*=(num%10);
                num/=10;
            }if(prod%t==0) break;
            ans++;
        }return ans;
    }
}