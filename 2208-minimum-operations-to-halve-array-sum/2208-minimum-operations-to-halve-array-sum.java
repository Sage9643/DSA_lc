class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> heap=new PriorityQueue<>(Collections.reverseOrder());
        double sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            heap.add((double)nums[i]);
        }
        int turns=0;
        double halfSum=0;
        while(halfSum<((double)sum/2)){
            double num=heap.remove();
            halfSum+=(double)num/2;
            heap.add((double)num/2);
            turns++;
        }return turns;
    }
}