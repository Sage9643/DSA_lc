class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        HashSet<List<Integer>> set=new HashSet<>();

        for(int num:nums) map.put(num,map.getOrDefault(num,0)+1);

        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<nums.length;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int num1=nums[i];
                int num2=nums[j];

                int req=(-1)*(num1+num2);

                if(!map.containsKey(req)) continue;
                else{
                    int freq=map.get(req);
                    if(num1==req) freq--;
                    if(num2==req) freq--;

                    if(freq>0){
                        List<Integer> arr=new ArrayList<>();
                        arr.add(num1);
                        arr.add(num2);
                        arr.add(req);

                        Collections.sort(arr);
                        set.add(arr);
                    }
                }
            }
        }List<List<Integer>> ans=new ArrayList<>(set);
        return ans;
    }
}