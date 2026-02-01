class Solution {
    public int countMonobit(int n) {
        if(n==0) return 1;
        if(n==1) return 2;

        int cnt=2;

        for(int i=3;i<=n+1;i++){
            if((i&(i-1))==0) cnt++;
        }return cnt;
    }
}