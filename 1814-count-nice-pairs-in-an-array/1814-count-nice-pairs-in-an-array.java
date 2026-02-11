class Solution {
    public int countNicePairs(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int pairs=0;

        for(int i=0;i<nums.length;i++){
            int res=nums[i]-rev(nums[i]);
            if(map.containsKey(res)) pairs=(pairs+map.get(res))%1000000007;
            map.put(res,map.getOrDefault(res,0)+1);
        }return pairs;
        
    }
    public static int rev(int num){
        int ans=0;
        while(num!=0){
            ans*=10;
            ans+=num%10;
            num/=10;
        }
        return ans;
    }
}