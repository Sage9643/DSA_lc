class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int maxEnergy=Integer.MIN_VALUE;

        for (int i=energy.length-1;i>=0;i--) {
            if(i+k<energy.length) energy[i]+=energy[i+k];
            maxEnergy=Math.max(maxEnergy,energy[i]);
        }
        return maxEnergy;
    }
}
