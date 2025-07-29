class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==1){
            return s;
        }
        String palindrome="";
        int maxlength=0;
        //traversing through each element of string and building upon it and checking palindrome
        for(int i=0;i<s.length();i++){
            //checking for odd length palindrome;
            int left=i,right=i;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                if(maxlength<right-left+1){
                    palindrome=s.substring(left,right+1);
                    maxlength=right-left+1;
                }left--;right++;
            }
            //checking for even length palindrome
            left=i;right=i+1;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                if(maxlength<right-left+1){
                    palindrome=s.substring(left,right+1);
                    maxlength=right-left+1;
                }left--;right++;
            }

        }return palindrome;
    }
}