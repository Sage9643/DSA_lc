class Solution {
    public boolean judgeSquareSum(int c) {
        if(c==0) return true;
        HashSet<Integer> set=new HashSet<>();

        for(int i=0;i<=(int)Math.sqrt(c);i++){
            if(!set.contains(c-(i*i))) set.add(i*i);
            else return true;
            if(!set.contains(c-(i*i))) set.add(i*i);
            else return true;
        }
        return false;
    }
}