class Solution {
    public int trailingZeroes(int n) {
        int count2=0;
        int count5=0;
        for(int i=n;i>0;i--){
            int num=i;
            while(num!=0 && num%2==0){
                count2++;
                num/=2;
            }while(num!=0 && num%5==0){
                count5++;
                num/=5;
            }
        }
        return Math.min(count2,count5);
    }
}