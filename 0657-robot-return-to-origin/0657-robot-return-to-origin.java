class Solution {
    public boolean judgeCircle(String moves) {
        int u=0,d=0,l=0,r=0;
        for(char ch:moves.toCharArray()){
            if(ch=='U') u++;
            else if(ch=='D') d++;
            else if(ch=='L') l++;
            else r++;
        }if(l==r && u==d) return true;
        return false;
    }
}