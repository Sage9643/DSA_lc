class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums,(str1,str2) ->{
            if(str1.length()!=str2.length())  return str2.length()-str1.length();

            else return str2.compareTo(str1);
        });

        int idx=0;
        for(int i=0;i<k-1;i++){
            idx++;
        }
        return nums[idx];
    }
}