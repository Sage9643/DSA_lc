class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> ans=new ArrayList<>();
        if(tomatoSlices<(2*cheeseSlices)) return ans;
        for(int i=cheeseSlices;i>=0;i--){
            if(((2*i)+(4*(cheeseSlices-i)))==tomatoSlices){
                ans.add(cheeseSlices-i);ans.add(i);
                return ans;
            }
        }return ans;
    }
}