class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int max=0;int satisfied=0;
        int i=0;

        for(;i<minutes;i++){
            if(grumpy[i]==0) satisfied+=customers[i];
            else max+=customers[i]; 
        }int cons=max;
        while(i<customers.length){
            if(grumpy[i]==0) satisfied+=customers[i];
            else max+=customers[i];
            if(grumpy[i-minutes]==1) max-=customers[i-minutes];
            
            cons=Math.max(cons,max);
            i++;
        }return satisfied+cons;
    }
}