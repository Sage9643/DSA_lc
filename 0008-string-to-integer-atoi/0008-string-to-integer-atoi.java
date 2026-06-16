class Solution {
    public int myAtoi(String s) {
        StringBuilder sb=new StringBuilder();
        int i=0;

        while(i<s.length() && s.charAt(i)==' ') i++;

        for(;i<s.length();i++){
            if((s.charAt(i)=='-' && sb.length()==0) || (s.charAt(i)=='+' && sb.length()==0) || (s.charAt(i)>='0' && s.charAt(i)<='9')) sb.append(s.charAt(i));
            else break;
            if((sb.length()==1 && sb.charAt(0)=='-') || (sb.length()==1 && sb.charAt(0)=='+')) continue;
            if(sb.length()>0 && Long.parseLong(sb.toString())>=Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sb.length()>0 && Long.parseLong(sb.toString())<=Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        if(sb.length()==0) return 0;
        if(sb.length()==1 && sb.charAt(0)=='-') return 0;
        if((sb.length()==1 && sb.charAt(0)=='-') || (sb.length()==1 && sb.charAt(0)=='+')) return 0;
        long ans=Long.parseLong(sb.toString());

        if(ans>=Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(ans<=Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) ans;


    }
}