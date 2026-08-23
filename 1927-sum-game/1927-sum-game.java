class Solution {
    public boolean sumGame(String num) {
        int n=num.length()/2;
        int sum1=0;
        int sum2=0;
        int q1=0;
        int q2=0;

        for(int i=0;i<n;i++){
            if(num.charAt(i)=='?') q1++;
            else sum1+=(num.charAt(i)-'0');

            if(num.charAt(n+i)=='?') q2++;
            else sum2+=(num.charAt(n+i)-'0');

        }
        if(q1+q2==0){
            if(sum1==sum2) return false;
            else return true;
        }
        else if((q1+q2)%2!=0) return true;
        else if(q1==q2){
            if(sum1==sum2) return false;
            else return true;
        }

        else{
            int min=Math.min(q1,q2);
            q1-=min; q2-=min;

            int q=Math.abs(q1-q2)/2;
            int diff=Math.abs(sum1-sum2);
            if(Math.abs(q1-q2)%2!=0) return true;
            if((q1>0 && sum1>=sum2) || (q2>0 && sum2>=sum1)) return true;

            if(q*9==diff) return false;
        }
        return true;
    }
}