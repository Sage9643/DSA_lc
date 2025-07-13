class Solution {
    public int[] countBits(int n) {
        int res[]=new int[n+1];
        res[0]=0;
        for(int i=1;i<n+1;i++){
            int num=i;
            int count=0;
            while(num>0){
                num=(num & num-1);
                count++;
            }res[i]=count;
        }return res;
    }
}