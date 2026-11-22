class Solution {
    public boolean checkString(String s) {
        int cntb=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='b') cntb++;
            else{
                if(cntb>0) return false;
            }
        }return true;
    }
}