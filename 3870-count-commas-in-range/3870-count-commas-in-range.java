class Solution {
    public int countCommas(int n) {
        int ans=0;
        for(int i=1000;i<=n;i++){
            String s=Integer.toString(i);
            ans+=((s.length()-1)/3);
        }return ans;
    }
}