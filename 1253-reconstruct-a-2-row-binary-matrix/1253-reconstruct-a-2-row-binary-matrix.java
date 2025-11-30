class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> ans=new ArrayList<>();
        
        int totsum=0,count2=0;

        for(int sum:colsum){
            totsum+=sum;
            if(sum==2) count2++;
        }    
        if((totsum!=(upper+lower)) || (count2>upper || count2>lower)) return ans;

        List<Integer> row1=new ArrayList<>();
        List<Integer> row2=new ArrayList<>();

        ans.add(row1);ans.add(row2);

        for(int k=0;k<colsum.length;k++){
            row1.add(0);row2.add(0);
        }
        int i=0,j=0;

        for(int sum:colsum){
            if(sum==2){
                row1.set(i,1);
                row2.set(j,1);
                upper--;lower--;
            }else if(sum==1){
                if(lower>upper){
                    row2.set(j,1);lower--;
                }else{
                    row1.set(i,1);upper--;
                }
            }
            i++;j++;
        }return ans;
    }
}