class Solution {
    public boolean hasAlternatingBits(int n) {
        String s=binary(n);
        char last=s.charAt(0);

        for(int i=1;i<s.length();i++){
            if(last==s.charAt(i)) return false;
            last=s.charAt(i);
        }return true;

    }public static String binary(int n){
        StringBuilder sb=new StringBuilder();
        while(n>1){
            int rem=n%2;
            sb.append(Integer.toString(rem));
            n/=2;
        }if(n==1) sb.append("1");
        return sb.reverse().toString();
    }
}