class Solution {
    public int possibleStringCount(String word) {
        int count=0;
        for(int i=0;i<word.length();i++){
            while(i<word.length()-1 && word.charAt(i)==word.charAt(i+1) ){
                count++;i++;
            }
        }return count+1;//in this problem we have to basically return the no of times a character repeats -1 ,this will give us the number of possible word and then add 1 for the given original word
    }
}