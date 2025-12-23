class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<HashSet<String>> sets=new ArrayList<>();
        for(List<String> list:favoriteCompanies) sets.add(new HashSet<>(list));

        List<Integer> ans=new ArrayList<>();

        for(int i=0;i<favoriteCompanies.size();i++){
            boolean isSubset=false;

            for (int j=0;j<favoriteCompanies.size();j++) {
                if(i==j) continue;

                if(sets.get(j).size()>=sets.get(i).size() && sets.get(j).containsAll(sets.get(i))){
                    isSubset=true;
                    break;
                }
            }if (!isSubset) ans.add(i);
        }return ans;
    }
}
