class Solution {
    int arr[] ;
    public Solution(int[] nums) {
        arr=nums;
    }
    
    public int pick(int target){
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target) list.add(i);
        }Random idx=new Random();
        int randomIdx=idx.nextInt(list.size());
        return list.get(randomIdx);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */