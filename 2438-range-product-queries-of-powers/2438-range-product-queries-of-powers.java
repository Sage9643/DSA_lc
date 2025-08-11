class Solution {
    public int[] productQueries(int num, int[][] queries) {
        ArrayList<Integer> powers=new ArrayList<>();
        long mod=1000000007;

        for(int i=0;i<32;i++) {
            if((num & (1<<i))>0) powers.add(1<<i);
        }

        int ans[]=new int[queries.length];
        int idx=0;

        for (int[] arr:queries) {
            long prod=1;
            for (int i=arr[0];i<=arr[1];i++) {
                prod=(prod*powers.get(i))%mod;
            }
            ans[idx++]=(int)prod;
        }
        return ans;
    }
}
