class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int uniqnums=0;
        for(int i=1;i<=n;i++){
            int nums=1;
            if(i==1) nums=10;
            else{
                nums*=9;
                int multiplier=9;
                int count=2;
                while(count<=i){
                    nums*=multiplier;
                    multiplier--;
                    count++;
                }
            }
            uniqnums+=nums;
        }return n==0?1:uniqnums;
    }
}