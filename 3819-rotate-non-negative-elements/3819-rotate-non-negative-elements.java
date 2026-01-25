class Solution {
    public int[] rotateElements(int[] nums, int k) {
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i:nums){
            if(i>=0) arr.add(i);
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        int ind=0;
        if(arr.size()==0) return nums;
        k%=arr.size();

        for(int i:arr){
            map.put(((ind-k)+arr.size())%arr.size(),i);
            ind++;
        }for(int i:map.keySet()){
            
            arr.set(i,map.get(i));
        }ind=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                nums[i]=arr.get(ind);
                ind++;
            }    
        }return nums;
    }
}