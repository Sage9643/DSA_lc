class Solution {
    public int reverse(int x) {
        if (x>Integer.MIN_VALUE && x<Integer.MAX_VALUE){
            int rev=0;
            int newx=Math.abs(x);
            int dig=0;
            int len=Integer.toString(newx).length()-1;
            while (newx>0){
                dig=newx%10;
                if (rev<Integer.MAX_VALUE && rev>Integer.MIN_VALUE){
                    rev+=dig*Math.pow(10,len);
                    newx/=10;
                    len--;
                }else{
                    return 0;
                }
                
            }
            if(x<0){
                return rev*(-1);
            }return rev;
        }return 0;
    }
}