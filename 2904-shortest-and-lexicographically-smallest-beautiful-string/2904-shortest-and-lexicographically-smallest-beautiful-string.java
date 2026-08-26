class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        
        int len=Integer.MAX_VALUE;
        int i=0,j=0;
        int cnt1=0;
        StringBuilder sb=new StringBuilder();
        for(int h=0;h<=k;h++) sb.append("1");
        String str=sb.toString();
        
        while(j<s.length()){
            if(s.charAt(j)=='1') cnt1++;

            while(cnt1==k){
                String st=s.substring(i,j+1);
                if(len>j-i+1){
                    len=j-i+1;
                    sb=new StringBuilder(st);
                        
                }else if(len==j-i+1){
                    if(sb.toString().compareTo(st)>=0){
                        sb=new StringBuilder(st);
                    }
                }
                if(s.charAt(i)=='1') cnt1--;
                i++;
            }
            j++;
        }if(sb.toString().equals(str)) return "";
        return sb.toString();
    }
}