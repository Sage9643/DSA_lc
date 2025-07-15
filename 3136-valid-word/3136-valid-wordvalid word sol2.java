class Solution {
    public boolean isValid(String word) {
        String wordDup=word.toUpperCase();
        if(wordDup.length()<3){
            return false;
        }int vowel=0;
        int consonant=0;
        for(int i=0;i<wordDup.length();i++){
            if(!Character.isLetterOrDigit(wordDup.charAt(i))){
                return false;
            }else if(Character.isLetter(wordDup.charAt(i))){
                if(wordDup.charAt(i) == 'A' || wordDup.charAt(i) == 'E' || wordDup.charAt(i) == 'I' || wordDup.charAt(i) == 'O' || wordDup.charAt(i) == 'U' ){
                    vowel++;
                }else{
                    consonant++;
                }
            }
        }if(consonant<1 || vowel<1){
            return false;
        }return true;
    }
}