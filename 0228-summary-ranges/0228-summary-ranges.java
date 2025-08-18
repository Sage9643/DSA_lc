class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> range=new ArrayList<>();
        int i=0;int j=0;
        while(j<nums.length){
            if(j<nums.length-1 && nums[j+1]==nums[j]+1) j++;
            else{
                StringBuilder sb=new StringBuilder();
                if(i!=j){ sb.append(Integer.toString(nums[i]));sb.append("->");sb.append(Integer.toString(nums[j]));}
                else sb.append(Integer.toString(nums[i]));

                range.add(sb.toString());
                i=j+1;j++;
            }
        }return range;

    }
}