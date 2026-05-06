class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int m=0,d=0;
        for(char ch:moves.toCharArray()){
            if(ch=='L') m--;
            else if(ch=='R') m++;
            else d++;
        }return Math.abs(m)+d;
    }
}