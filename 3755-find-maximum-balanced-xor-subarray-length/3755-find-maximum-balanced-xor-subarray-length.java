class Solution {
    public int maxBalancedSubarray(int[] nums) {
        HashMap<String,Integer> map=new HashMap<>();
        map.put("0,0",-1);
        int diff=0, xor=0;
        int len=0;int idx=0;

        for(int num:nums){
            diff+=num%2==0?1:-1;
            xor=xor^num;
            String el=xor+","+diff ;

            if(map.containsKey(el)) len=Math.max(len,idx-map.get(el));
            else map.put(el,idx);
            idx++;
        }
        return len;
    }
}