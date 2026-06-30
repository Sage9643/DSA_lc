class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int num:nums) map.put(num,map.getOrDefault(num,0)+1);

        int cnt=0;

        for(int num:nums){
            if(!map.containsKey(num)) continue;
            map.put(num,map.get(num)-1);
            if(map.get(num)==0) map.remove(num);

            int diff=k-num;
            if(map.containsKey(diff)){
                cnt++;
                map.put(diff,map.get(diff)-1);
                if(map.get(diff)==0) map.remove(diff);

            }
        }return cnt;
    }
}