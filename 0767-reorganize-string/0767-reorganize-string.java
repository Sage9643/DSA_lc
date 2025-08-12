class Solution {
    public String reorganizeString(String s) {
        int freq[]=new int[26];
        int maxCount=0;
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
            maxCount=Math.max(maxCount,freq[s.charAt(i)-'a']);
        }
        if(maxCount>(s.length()+1)/2) return "";
        char word[]=new char[s.length()];
        PriorityQueue<Character> chars=new PriorityQueue<>((char1,char2)->freq[char2-'a']-freq[char1-'a']);
        for(int k=0;k<freq.length;k++){
            if(freq[k]>0) chars.add((char)('a'+k));
        }
        int i=0;
        while(!chars.isEmpty()){
            char ch=chars.remove();
            while(freq[ch-'a']!=0){
                word[i]=ch;
                i+=2;freq[ch-'a']--;
                if(i>=word.length) i=1;
            }
        }return String.valueOf(word);
    }
}