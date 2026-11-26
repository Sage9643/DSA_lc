class Solution {
    public boolean canAliceWin(int n) {
        boolean turn=true;
        int remove=10;
        while(n-remove>=0){
            n-=remove;
            remove--;
            turn=!turn;
        }
        return !turn;
    }
}