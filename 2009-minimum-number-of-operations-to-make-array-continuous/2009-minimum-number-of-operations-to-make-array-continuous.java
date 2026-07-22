class Solution {
    public int minOperations(int[] nums) {
        
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums) set.add(num);
        ArrayList<Integer> arr=new ArrayList<>(set);

        Collections.sort(arr);
        
        int n=nums.length;
        int m=arr.size();
        int i=0,j=0;

        int maxsize=0;

        while(j<m){
            
            while(i<m && j<m && arr.get(j)-arr.get(i)>=n) i++;
            if(j==m) break;

            maxsize=Math.max(maxsize,j-i+1);
            j++;   
        }
        return n-maxsize;
    }
}