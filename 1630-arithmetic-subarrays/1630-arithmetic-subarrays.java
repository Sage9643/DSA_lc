class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans=new ArrayList<>();

        for(int i=0;i<l.length;i++){
            int s=l[i];
            int e=r[i];

            int arr[]=new int[e-s+1];

            for(int j=s;j<=e;j++){
                arr[j-s]=nums[j];
            }
            Arrays.sort(arr);
            int diff=arr[1]-arr[0];
            boolean valid=true;

            for(int j=1;j<arr.length-1;j++){
                if(arr[j+1]-arr[j]!=diff){
                    ans.add(false);
                    valid=false;
                    break;
                }
            }if(valid) ans.add(true);
        
        }return ans;
    }
}