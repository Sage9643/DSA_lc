class Solution {
    public int findJudge(int n, int[][] trust) {
        int indegree[]=new int[n+1];
        int outdegree[]=new int[n+1];

        for(int pair[]:trust){
            outdegree[pair[0]]++;
            indegree[pair[1]]++;
        }for(int i=1;i<n+1;i++){
            if(indegree[i]==n-1 && outdegree[i]==0) return i;
        }return -1;
    }
}