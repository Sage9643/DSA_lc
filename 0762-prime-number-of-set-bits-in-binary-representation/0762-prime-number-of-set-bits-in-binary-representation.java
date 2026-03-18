class Solution {
    public int countPrimeSetBits(int left, int right) {
        int cnt=0;
        for(int i=left;i<=right;i++){
            int setbit=0;
            int num=i;
            while(num>0){
                num=num&(num-1);
                setbit++;
            }if(isPrime(setbit)) cnt++;
        }return cnt;
    }
    public static boolean isPrime(int num){
        if(num==1) return false;
        for(int i=2;i*i<=num;i++){
            if(num%i==0) return false;
        }
        return true;
    }
}