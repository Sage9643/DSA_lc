class Solution {
    public boolean checkOnesSegment(String s) {
        int seg=0;
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='1'){
                if(seg>0) return false;
                while(i<s.length() && s.charAt(i)=='1') i++;
                seg++;
            }i++;
        }if(seg==1) return true;
        return false;
    }
}