class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        HashSet<Integer> setx=new HashSet<>();
        HashSet<Integer> sety=new HashSet<>();
        HashSet<Integer> temp=new HashSet<>();

        if(x==1 && y==1) return bound>=2? Arrays.asList(2):new ArrayList<>();

        int powx=1;
        int powy=1;
        while(powx<=bound){
            setx.add(powx);
            powx=powx*x;
            if(powx==1) break;
        }
        while(powy<=bound){
            sety.add(powy);
            powy=powy*y;
            if(powy==1) break;
        }
        for(int num:setx){
            for(int pow:sety){
                if((num+pow)<=bound) temp.add(num+pow);
            }
        }List<Integer> ans=new ArrayList<>(temp);
        return ans;
    }
}