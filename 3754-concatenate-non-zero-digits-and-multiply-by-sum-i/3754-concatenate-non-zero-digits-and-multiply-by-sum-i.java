class Solution {
    public long sumAndMultiply(int n) {
        if(n==0) return 0;
        long sum=0;
        StringBuilder sb=new StringBuilder();

        while(n>=1){
            if(n%10!=0)sb.append(Integer.toString(n%10));
            sum+=n%10;
            n/=10;
        }sb.reverse();
        return Integer.parseInt(sb.toString())*sum;
        
    }
}