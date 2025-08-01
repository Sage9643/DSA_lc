class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(1);

        for(int i=0;i<rowIndex;i++){
            ArrayList<Integer> currow=new ArrayList<>();
            currow.add(1);

            for(int j=0;j<ans.size()-1;j++){
                currow.add(ans.get(j)+ans.get(j+1));
            }currow.add(1);
            ans.clear();
            ans.addAll(currow);
        }return ans;
    }
}