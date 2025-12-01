class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length()==1) return "";
        StringBuilder sb=new StringBuilder(palindrome);
        
        for(int i=0;i<sb.length();i++){
            int stop=sb.charAt(i)-'a';
            for(int j=0;j<stop;j++){
                StringBuilder mod=new StringBuilder(sb);
                mod.setCharAt(i,(char)('a'+j));
                if(!isPalindrome(mod)) return mod.toString();
            }
        }for(int i=0;i<26;i++){
            StringBuilder mod=new StringBuilder(sb);
            mod.setCharAt(sb.length()-1,(char)('a'+i));
            if(!isPalindrome(mod)) return mod.toString();
        }return "";
    }public boolean isPalindrome(StringBuilder sb){
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)!=sb.charAt(sb.length()-1-i)) return false;
        }return true;
    }
}