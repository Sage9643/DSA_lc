class Solution {
    public int passwordStrength(String password) {
        int s=0;
        HashSet<Character> set=new HashSet<>();

        for(char ch:password.toCharArray()){
            if(!set.contains(ch)){
                if(ch>='a' && ch<='z') s++;
                else if(ch>='A' && ch<='Z') s+=2;
                else if(ch>='0' && ch<='9') s+=3;
                else if(ch=='!' || ch=='@' || ch=='#' || ch=='$') s+=5;
                set.add(ch);
            }   
        }return s;
    }
}