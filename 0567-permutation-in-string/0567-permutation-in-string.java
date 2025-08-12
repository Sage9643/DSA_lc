class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()) return false;

        int s1freq[]=new int[26];int s2subfreq[]=new int[26];
        for(char ch:s1.toCharArray()) s1freq[ch-'a']++;
        for(int i=0;i<s1.length();i++){
            s2subfreq[s2.charAt(i)-'a']++;
        }if(Arrays.equals(s2subfreq,s1freq)) return true;

        for(int i=s1.length();i<s2.length();i++){
            s2subfreq[s2.charAt(i)-'a']++;
            s2subfreq[s2.charAt(i-s1.length())-'a']--;

            if(Arrays.equals(s2subfreq,s1freq)) return true;
        }
        return false;
    }
}