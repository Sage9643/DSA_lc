class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums) map.put(num,map.getOrDefault(num,0)+1);

        List<Integer> bucket[]=new List[nums.length+1];

        for(Integer key:map.keySet()){
            Integer freq=map.get(key);
            if(bucket[freq]==null) bucket[freq]=new ArrayList<>();
            bucket[freq].add(key);
        }
        int index=0;
        int ans[]=new int[k];
        for(int freq=bucket.length-1;freq>=0 && index<k;freq--){
            if(bucket[freq]!=null){
                for(int num:bucket[freq]){
                    ans[index++]=num;
                    if(index==k)return ans;
                }
            }
        }return ans;
    }
}