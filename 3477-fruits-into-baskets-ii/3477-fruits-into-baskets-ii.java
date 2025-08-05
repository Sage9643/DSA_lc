class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] basket) {
        int unplaced=0;
        for(int i=0;i<fruits.length;i++){
            for(int j=0;j<basket.length;j++){
                if(basket[j]>=fruits[i]){
                    basket[j]=0;
                    break;
                }else{
                    if(j==basket.length-1) unplaced++;
                }
            }
        }return unplaced;
    }
}