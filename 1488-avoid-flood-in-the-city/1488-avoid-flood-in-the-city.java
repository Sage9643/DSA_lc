class Solution {
    public int[] avoidFlood(int[] rains) {
        int ans[]=new int[rains.length];
        HashMap<Integer,Integer> map=new HashMap<>();
        TreeSet<Integer> zero=new TreeSet<>();

        for(int i=0;i<rains.length;i++){
            if(rains[i]!=0){
                if(!map.containsKey(rains[i])) {
                    map.put(rains[i],i);
                    ans[i]=-1;
                }else{
                    int idx=bs(zero,map.get(rains[i]),i);
                    if(idx==-1) return new int[]{};
                    else{
                        ans[i]=-1; ans[idx]=rains[i];
                        zero.remove(idx);
                        map.put(rains[i],i);
                    }
                }
            }else{
                zero.add(i);
                ans[i]=1;
            }
        }return ans;
    }
    public static int bs(TreeSet<Integer> set,int s,int e){
        Integer idx=set.ceiling(s+1);
        if(idx!=null && idx<e) return idx;
        return -1;
    }
}
