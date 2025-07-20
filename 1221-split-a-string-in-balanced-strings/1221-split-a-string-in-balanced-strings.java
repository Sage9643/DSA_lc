class Solution {
    public int balancedStringSplit(String s) {
        int count=0;
        int balanced=0;
        for(int i=0;i<s.length();i++){
            balanced+=s.charAt(i)=='R'? -1:1;
            if(balanced==0){
                count++;
            }
        }
        return count;
    }

}