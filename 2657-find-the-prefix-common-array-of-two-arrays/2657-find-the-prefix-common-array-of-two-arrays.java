class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int count=0;
        HashSet<Integer> set=new HashSet<>();
        int ans[]=new int[A.length];
        for(int i=0;i<A.length;i++){
            if(!set.contains(A[i])) set.add(A[i]);
            else count++;

            if(!set.contains(B[i])) set.add(B[i]);
            else count++;

            ans[i]=count;
        }
        return ans;
    }
}