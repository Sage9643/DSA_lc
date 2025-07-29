class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        int maxlength=1;
        HashSet<Character> set=new HashSet<>();
        int i=0,j=1;
        set.add(s.charAt(0));
        while(i<s.length() && j<s.length()){
            if(set.contains(s.charAt(j))){
                while(i<s.length() && set.contains(s.charAt(j))){
                    set.remove(s.charAt(i));
                    i++;
                }
            }
            set.add(s.charAt(j));
            maxlength=Math.max(set.size(),maxlength);
            j++;
        }
        return maxlength;
    }
}