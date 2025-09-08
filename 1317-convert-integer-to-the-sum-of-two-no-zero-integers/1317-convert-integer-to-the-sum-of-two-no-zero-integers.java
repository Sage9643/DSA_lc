class Solution {
    public int[] getNoZeroIntegers(int n) {
        for(int num1=1;num1<n;num1++){
            int num2=n-num1;

            if(check(num1) && check(num2)) return new int[] {num1,num2};       
        } return new int[]{};
    }public boolean check(int num){
        while(num!=0){
            if(num%10==0) return false;
            num=num/10;
        }return true;
    }
}