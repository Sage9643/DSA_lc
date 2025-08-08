class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<row> heap=new PriorityQueue<>();
        int ans[]=new int[k];

        int ones=0;
        
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1) ones++;
            }heap.add(new row(ones,i));
            ones=0;
        }
        for(int i=0;i<k;i++){
            ans[i]=heap.remove().idx;
        }
        return ans;
    }
}class row implements Comparable<row>{
    int ones;
    int idx;

    public row(int ones,int idx){
        this.ones=ones;
        this.idx=idx;
    }public int compareTo(row r){
        if(this.ones!=r.ones){
            return this.ones-r.ones;
        }else return this.idx-r.idx;

    }



}