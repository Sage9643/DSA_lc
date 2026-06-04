class Solution {
    public int totalWaviness(int num1, int num2) {
        int cnt=0;
        for(int i=num1;i<=num2;i++) cnt+=wave(i);
        return cnt;
    }public int wave(int n){
        String num=Integer.toString(n);
        int cnt=0;

        for(int i=1;i<num.length()-1;i++){
            if(((num.charAt(i)-'0')>(num.charAt(i-1)-'0')) && ((num.charAt(i)-'0')>(num.charAt(i+1)-'0'))) cnt++;
            if(((num.charAt(i)-'0')<(num.charAt(i-1)-'0')) && ((num.charAt(i)-'0')<(num.charAt(i+1)-'0'))) cnt++;
        }return cnt;
    }
}