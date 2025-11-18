class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        if(bits.length==1) return true;
        int i=0;
        while(i<bits.length-1){
            if(bits[i]==1) i+=2;
            else i++;
        }if(i==bits.length)return false;
        return true;
    }
}