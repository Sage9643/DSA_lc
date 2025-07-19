class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> d=new LinkedList<>();
        int output[]=new int[nums.length-k+1];
        for(int i=0;i<k;i++){
            while(!d.isEmpty() && nums[d.getLast()]<=nums[i]){
                d.removeLast();
            }d.addLast(i);

        }output[0]=nums[d.getFirst()];
        int idx=1;
        
        for(int i=k;i<nums.length;i++){
            while(!d.isEmpty() && d.getFirst()<i-k+1){
                d.removeFirst();
            }while(!d.isEmpty() && nums[d.getLast()]<=nums[i]){
                d.removeLast();
            }d.addLast(i);
            output[idx]=nums[d.getFirst()];
            idx++;
        }return output;
    }
}