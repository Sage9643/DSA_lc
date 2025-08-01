class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        pascalTriangle(ans,numRows);
        return ans;
    }public static void pascalTriangle(List<List<Integer>> ans,int remrows){
        if(remrows==0){
            return;
        }pascalTriangle(ans,remrows-1);
        List<Integer> row=new ArrayList<>();
        row.add(1);
        List<Integer> ref=ans.size()==0?new ArrayList<>():ans.get(ans.size()-1);

        for(int i=0;i<ref.size()-1;i++){
            row.add(ref.get(i)+ref.get(i+1));
        }if(ans.size()!=0) row.add(1);
        ans.add(row);
        
    }
}