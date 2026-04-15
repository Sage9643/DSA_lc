class Solution {
    public int tribonacci(int n) {
        if(n==2 || n==1) return 1;
        if(n==0) return 0;
        int a=0,b=1,c=1;

        for(int i=0;i<n-2;i++){
            int d=a+b+c;
            a=b;
            b=c;
            c=d;
        }return c;
    }
}