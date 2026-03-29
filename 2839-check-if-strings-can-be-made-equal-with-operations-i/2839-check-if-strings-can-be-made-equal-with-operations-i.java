class Solution {
    public boolean canBeEqual(String s1, String s2) {
        String s3=""+s1.charAt(2)+s1.charAt(1)+s1.charAt(0)+s1.charAt(3);
        String s4=""+s1.charAt(0)+s1.charAt(3)+s1.charAt(2)+s1.charAt(1);
        String s5=""+s1.charAt(2)+s1.charAt(3)+s1.charAt(0)+s1.charAt(1);

        if(s2.equals(s1) ||s2.equals(s3) ||s2.equals(s4) ||s2.equals(s5)) return true;
        return false;
    }
}