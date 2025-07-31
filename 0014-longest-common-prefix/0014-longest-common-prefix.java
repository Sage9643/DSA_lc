class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans=strs[0];
        for(int i=0;i<strs.length;i++){
            if(ans.length()>strs[i].length()){
                ans=strs[i];
            }
        }int j=ans.length();
        if(j==0 || strs.length==1){
            return ans;
        }for(int i=0;i<strs.length;i++){
            if(j>0 && !strs[i].substring(0,j).equals(ans.substring(0,j))){
                while(j>0 && !strs[i].substring(0,j).equals(ans.substring(0,j)))j--;
                ans=ans.substring(0,j);
            }
        }return ans;
    }
}