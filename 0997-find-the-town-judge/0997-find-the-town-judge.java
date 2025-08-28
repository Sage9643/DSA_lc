class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trusts=new int[n+1];
        int trusted[]=new int[n+1];

        for(int[] t:trust){
            trusts[t[0]]++;
            trusted[t[1]]++;
        }
        for(int i=1;i<n+1;i++){
            if(trusted[i]==n-1 && trusts[i]==0) return i;
        }return -1;
    }
}