class Solution {
    public int specialTriplets(int[] nums) {
        long mod=1000000007;
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])) map.put(nums[i],new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        long cnt=0;

        for(int k:map.keySet()){
            if(map.containsKey(k*2)){
                ArrayList<Integer> idx=map.get(k);
                if(k!=k*2){
                    ArrayList<Integer> tofind=map.get(k*2);
                    for(int a:idx){
                        int n=bs(tofind,a);
                        if(n!=tofind.size()) cnt=(cnt%mod+((long)n*(tofind.size()-n))%mod)%mod;
                    }
                }else{
                    for(int i=1;i<idx.size()-1;i++) cnt=(cnt%mod+((long)i*(idx.size()-i-1))%mod)%mod;
                }
                
            }
        }return (int)cnt;
    }public static int bs(ArrayList<Integer> arr,int i){
        int start=0,end=arr.size()-1;
        int idx=arr.size();

        while(start<=end){
            int mid=(start+end)/2;
            if(arr.get(mid)>=i){
                idx=mid;
                end=mid-1;
            }else start=mid+1;
        }return idx;
    }
}