class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> overlap=new ArrayList<>();
        int i=0,j=0;

        while(i<firstList.length && j<secondList.length){

            int ll=Math.max(secondList[j][0],firstList[i][0]);
            int ul=Math.min(secondList[j][1],firstList[i][1]);
            if(ll<=ul){
                overlap.add(new int[]{ll,ul});
            }  
    
            if(secondList[j][1]<firstList[i][1]) j++;
            else if(secondList[j][1]>firstList[i][1]) i++;
            else{ i++;j++;}
        }
        int[][] ans=new int[overlap.size()][2];
        for(int k=0;k<overlap.size();k++){
            ans[k]=overlap.get(k);
        }
        return ans;
    }
}