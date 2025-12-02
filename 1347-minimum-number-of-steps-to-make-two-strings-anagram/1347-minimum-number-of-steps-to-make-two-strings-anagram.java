class Solution {
    public int minSteps(String s, String t) {
        int freq1[]=new int[26];
        int freq2[]=new int[26];

        for(char ch:s.toCharArray())freq1[ch-'a']++;
        for(char ch:t.toCharArray())freq2[ch-'a']++;

        int extra=0;

        for(int i=0;i<26;i++){
            if(freq2[i]>freq1[i]) extra+=(freq2[i]-freq1[i]);
        }return extra;

    }
}