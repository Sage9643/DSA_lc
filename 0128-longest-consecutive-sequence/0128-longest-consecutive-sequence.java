class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums) set.add(num);

        int maxConsecutiveLen=0;
        for(Integer num:set){
            if(!set.contains(num-1)){//only counting consecutives if num is start of a sequence
                int currNum=num;
                int currLen=1;
                while(set.contains(currNum+1)){
                    currNum++;
                    currLen++;
                }maxConsecutiveLen=Math.max(maxConsecutiveLen,currLen);
            }
        }return maxConsecutiveLen;
    }
}