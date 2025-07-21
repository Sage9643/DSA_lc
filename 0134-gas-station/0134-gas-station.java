class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /*int arr[][]=new int[gas.length][3];
        for(int i=0;i<gas.length;i++){
            arr[i][0]=i;
            arr[i][1]=Cost[i];
            arr[i][2]=gas[i];
        }
        Arrays.sort(arr,Comparator.comparingInt(o->o[1]));
        int cost=arr[0][1];
        int tank=arr[0][2];

        for(int i=1;i<gas.length;i++){
            if(tank<cost){
                return -1;
            }tank=tank-cost+arr[i][2];
            cost=arr[i][1];
        }if(tank<cost){
            return -1;
        }int max=arr[0][0];
        for(int i=0;i<arr.length-1;i++){
            if(arr[i][1]==arr[i+1][1]){
                max=arr[i+1][0];
            }else{
                break;
            }
        }return max;

        */
        int currgas=0;
        int idx=0;
        int totgas=0;
        int totcost=0;
        for(int i=0;i<gas.length;i++){
            totgas+=gas[i];
            totcost+=cost[i];
            currgas+=gas[i]-cost[i];
            if(currgas<0){
                currgas=0;
                idx=i+1;
            }
            
        }if(totgas<totcost){
            return -1;
        }return idx;

    }
}