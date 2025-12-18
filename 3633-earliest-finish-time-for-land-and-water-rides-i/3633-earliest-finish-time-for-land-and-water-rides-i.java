class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int tot=Integer.MAX_VALUE;
        for(int i=0;i<landDuration.length;i++){
            for(int j=0;j<waterDuration.length;j++){
                int t=landStartTime[i]+landDuration[i];
                if(t<waterStartTime[j]) t+=waterStartTime[j]-landStartTime[i]-landDuration[i];
                tot=Math.min(t+waterDuration[j],tot);
            }
        }for(int i=0;i<waterDuration.length;i++){
            for(int j=0;j<landDuration.length;j++){
                int k=waterStartTime[i]+waterDuration[i];
                if(k<landStartTime[j]) k+=landStartTime[j]-waterStartTime[i]-waterDuration[i];
                tot=Math.min(k+landDuration[j],tot);
            }
        }return tot;
        
    }
}