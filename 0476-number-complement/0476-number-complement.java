class Solution {
    public int findComplement(int num) {
        String bin=dectobin(num);
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<bin.length();i++){
            if(bin.charAt(i)=='0') sb.append('1');
            else sb.append('0');
        }
        return bintodec(sb.toString());
    }
    public static String dectobin(int num){
        StringBuilder sb=new StringBuilder();
        while(num>1){
            sb.append(Integer.toString(num%2));
            num/=2;
        }if(num==1) sb.append('1');

        return sb.reverse().toString();
    }public static int bintodec(String num){
        int pow=0;
        int ans=0;

        for(int i=num.length()-1;i>=0;i--){
            ans+=((int)(1<<pow)*(num.charAt(i)-'0'));
            pow++;
        }return ans;
    }
}