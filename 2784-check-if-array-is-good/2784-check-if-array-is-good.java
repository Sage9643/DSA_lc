class Solution {
    public boolean isGood(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=1;i<nums.length;i++){
            if(i!=nums.length-1)map.put(i,1);
            else map.put(i,2);
        }
        for(int num:nums){
            if(!map.containsKey(num)) return false;
            else{
                map.put(num,map.get(num)-1);
                if(map.get(num)==0) map.remove(num);
            }
        }
        return map.isEmpty();
    }
}