class Solution {
    static int mod=1000000007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        HashMap<Integer,ArrayList<int[]>> map=new HashMap<>();
        int lim=(int)Math.sqrt(nums.length);

        for(int q[]:queries){
            int l=q[0];
            int r=q[1];
            int step=q[2];
            int mul=q[3];

            if(step>=lim){
                for(int i=l;i<=r;i+=step) nums[i]=(int)(((long)nums[i]*mul)%mod);
            }else{
                if(!map.containsKey(step)) map.put(step,new ArrayList<>());
                map.get(step).add(q);
            }
        }for(int key:map.keySet()){
            ArrayList<int[]> arr=map.get(key);
            int diff[]=new int[nums.length];
            Arrays.fill(diff,1);

            for(int q[]:arr){
                int l=q[0];
                int r=q[1];
                int step=key;
                int mul=q[3];
                diff[l]=(int)(((long)diff[l]*mul)%mod);

                int last=l+((((r-l)/step)+1)*step);
                if(last<nums.length) diff[last]=(int)(((long)diff[last]*modinv(mul))%mod);

            }for(int i=0;i<nums.length;i++){
                if(i>=key) diff[i]=(int)(((long)diff[i]*diff[i-key])%mod);
            }
            
            for(int i=0;i<nums.length;i++){
                nums[i]=(int)(((long)nums[i]*diff[i])%mod);
            }
        }int xor=0;
        for(int num:nums) xor^=num;
        return xor;
    }
    public static int modinv(int a){
        int pow=mod-2;
        int ans=1;
        while(pow>0){
            if((pow&1)!=0) ans=(int)(((long)ans*a)%mod);
            pow=pow>>1;
            a=(int)(((long)a*a)%mod);
        }return ans;
    }
}