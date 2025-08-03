class Solution {
    public int addDigits(int num) {
        if(num==0)return 0;
        while(num /10!=0){
            int dig=num;
            num=0;
            while(dig!=0){
                num+=dig%10;
                dig=dig/10;
            }
        }return num;
    }
}