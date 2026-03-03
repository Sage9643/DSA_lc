class Solution {
    public char findKthBit(int n, int k) {
        String s=bitrep(n,"");
        return s.charAt(k-1);
    }
    public static String bitrep(int n,String s){
        if(n==1){
            s=s+"0";
            return s;
        }String ans=bitrep(n-1,s);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ans.length();i++){
            if(ans.charAt(i)=='1') sb.append("0");
            else sb.append("1");
        }
        return ans + "1" + sb.reverse().toString();
    }
}