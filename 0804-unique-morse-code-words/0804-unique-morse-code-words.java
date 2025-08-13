class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> uniqueMorse=new HashSet<>();
        String MorseCode[]={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for(String word:words){
            StringBuilder morse=new StringBuilder();
            for(char ch:word.toCharArray()){
                morse.append(MorseCode[ch-'a']);
            }uniqueMorse.add(morse.toString());
            
        }return uniqueMorse.size();
    }
}