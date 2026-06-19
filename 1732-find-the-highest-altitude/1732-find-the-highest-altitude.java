class Solution {
    public int largestAltitude(int[] gain) {
        int max=0;
        int alt=0;

        for(int g:gain){
            alt+=g;
            max=Math.max(max,alt);
        }return max;
    }
}