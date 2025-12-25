class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long h=0;
        Arrays.sort(happiness);
        int sub=0;

        for(int i=happiness.length-1;i>=0;i--){
            if(happiness[i]-sub>=0) h+=happiness[i]-sub;
            sub++;k--;
            if(k==0) break;
        }
        return h;
    }
}