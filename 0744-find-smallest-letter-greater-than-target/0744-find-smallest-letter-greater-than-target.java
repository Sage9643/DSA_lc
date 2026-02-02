class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        HashSet<Character> set=new HashSet<>();
        char ch='{';

        for(char c:letters){
            if(c>target && c<ch) ch=c;
        }return ch=='{'?letters[0]:ch;
    }
}