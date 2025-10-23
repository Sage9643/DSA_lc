class Solution {
    public boolean hasSameDigits(String s) {
        StringBuilder sb1=new StringBuilder(s);
        StringBuilder sb2=new StringBuilder();

        while(sb1.length()!=2){
            for(int i=0;i<sb1.length()-1;i++){
                int rem=((sb1.charAt(i)-'0')+(sb1.charAt(i+1)-'0'))%10;
                sb2.append(Integer.toString(rem));
            }sb1=new StringBuilder(sb2); sb2.setLength(0);  
        }
        if(sb1.charAt(0)==sb1.charAt(1)) return true;
        return false;
    }
}