class Solution {
    public long countCommas(long n) {
        long ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=4;i<=16;i++){
            map.put(i,(i-1)/3);
        }String str=Long.toString(n);

        if(str.length()<4) return 0;
        int j=4;
        for(;j<str.length();j++) {long cnt=9*(long)Math.pow(10,j-1);ans+=(cnt*map.get(j));}

        long c=(long)Math.pow(10,j-1);
        
        ans+=((n-c+1)*map.get(j));

        return ans;
        
    }
}