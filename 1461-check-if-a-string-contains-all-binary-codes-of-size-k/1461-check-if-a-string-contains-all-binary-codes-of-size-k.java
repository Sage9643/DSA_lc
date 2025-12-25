class Solution {
    public boolean hasAllCodes(String s, int k) {
        StringBuilder sb=new StringBuilder();
        HashSet<String> set=new HashSet<>();
        if(k>s.length()) return false;

        for(int i=0;i<k;i++) sb.append(s.charAt(i));

        set.add(sb.toString());
        for(int i=k;i<s.length();i++){
            StringBuilder st=new StringBuilder(sb.substring(1,sb.length())+s.charAt(i));
            set.add(st.toString());
            sb=new StringBuilder(st);
        }int el=(int)Math.pow(2,k);
        if(set.size()==el) return true;
        return false;
    }
}