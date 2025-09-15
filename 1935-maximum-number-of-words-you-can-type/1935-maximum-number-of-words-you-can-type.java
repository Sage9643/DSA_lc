class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String words[]=text.split(" ");
        int broken[]=new int[26];
        int count=0;

        for(char ch:brokenLetters.toCharArray()) broken[ch-'a']++;

        for(String word:words){
            boolean valid=true;
            for(char ch:word.toCharArray()){
                if(broken[ch-'a']!=0){
                    valid=false;
                    break;
                }
            }if(valid) count++;
        }return count;
    }
}