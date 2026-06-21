class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character> s1=new HashSet<>();
        HashSet<Character> s2=new HashSet<>();

        for(int i=word.length()-1;i>=0;i--){
            char ch=word.charAt(i);

            if(ch>='A' && ch<='Z'){
                char s=Character.toLowerCase(ch);
                if(!s1.contains(s)) s2.add(ch);
                else{
                    if(s2.contains(ch)) s2.remove(ch);
                }
            }else  s1.add(ch);
        }
        int cnt=0;

        for(char ch:s2){
            char s=Character.toLowerCase(ch);
            if(s1.contains(s)) cnt++;
        }
        return cnt;
    }
}