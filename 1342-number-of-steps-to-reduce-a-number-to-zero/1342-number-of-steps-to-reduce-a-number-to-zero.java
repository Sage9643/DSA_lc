class Solution {
    public int numberOfSteps(int num) {
        if(num==0){
            return 0;
        }
        int setbits=0;
        int res=0;int num1=num;
        while(num1!=0){
            num1=num1 & (num1-1);
            setbits++;
        }int j=0;
        res=2*setbits;
        while(setbits!=0 && j<32){
            if((num & (1<<j))>=1){
                setbits--;
            }else{
                res++;
            }j++;
        }return res-1;
    }
}