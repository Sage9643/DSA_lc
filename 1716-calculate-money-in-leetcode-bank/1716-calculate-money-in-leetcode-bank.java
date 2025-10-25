class Solution {
    public int totalMoney(int n) {
        if(n<=7) return (n*(n+1))/2;
        int days=n;
        int totMoney=0;int prevMoney=28;
        while(days>=7){
            totMoney+=prevMoney;
            prevMoney+=7;
            days-=7;
        }int rem=n%7;

        for(int i=(int)Math.ceil((double)n/7);i<(int)Math.ceil((double)n/7)+rem;i++) totMoney+=i;
        return totMoney;
    }
}