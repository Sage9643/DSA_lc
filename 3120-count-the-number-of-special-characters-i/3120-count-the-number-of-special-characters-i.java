class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character> set=new HashSet<>();
        for(char ch:word.toCharArray()) {
            if(ch>='A' && ch<='Z') set.add(ch);
        }
        HashSet<Character> used=new HashSet<>();
        int cnt=0;

        for(char ch:word.toCharArray()){
            if(ch>='a' && ch<='z'){
                if(!used.contains(ch)){
                    used.add(ch);
                    if(set.contains(Character.toUpperCase(ch))) cnt++;
                }
            }
        }return cnt;
    }
}