class Solution {
    public int minFlips(String target) {
        int curr=0,flips=0;

        for(char ch:target.toCharArray()) {
            if(curr!=ch-'0'){
                curr=1-curr;
                flips++;
            }
        }
        return flips;
    }
}