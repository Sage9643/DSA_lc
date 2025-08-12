class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length()>s.length()) return new ArrayList();
        int pfreq[]=new int[26];
        int substrfreq[]=new int[26];
        List<Integer> anagramIdx=new ArrayList<>();
        for(char ch:p.toCharArray()) pfreq[ch-'a']++;
        for(int i=0;i<p.length();i++){
            substrfreq[s.charAt(i)-'a']++;
        }if(Arrays.equals(pfreq,substrfreq)) anagramIdx.add(0);

        for(int i=p.length();i<s.length();i++){
            substrfreq[s.charAt(i)-'a']++;
            substrfreq[s.charAt(i-p.length())-'a']--;
            if(Arrays.equals(pfreq,substrfreq)) anagramIdx.add(i-p.length()+1);
        }
        return anagramIdx;
    }
}