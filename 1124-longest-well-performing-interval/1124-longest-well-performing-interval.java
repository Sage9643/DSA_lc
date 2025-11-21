class Solution {
    public int longestWPI(int[] hours) {
        int maxlen=0;
        for(int i=0;i<hours.length;i++){
            int g=0,l=0;
            for(int j=i;j<hours.length;j++){
                if(hours[j]>8)g++;
                else l++;
                if(g>l) maxlen=Math.max(maxlen,j-i+1);
            }
        }return maxlen;
    }
}