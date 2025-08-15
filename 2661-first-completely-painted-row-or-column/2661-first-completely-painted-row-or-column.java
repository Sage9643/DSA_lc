class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        HashMap<Integer,int[]> map=new HashMap<>();
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                map.put(mat[row][col],new int[]{row,col});
            }
        }
        int rows[]=new int[m];
        int cols[]=new int[n];
        Arrays.fill(rows,n);Arrays.fill(cols,m);//here each row contains n cols thatswhy filled with n and same for cols

        for(int i=0;i<arr.length;i++){
            int cell[]=map.get(arr[i]);
            rows[cell[0]]--;
            if(rows[cell[0]]==0) return i;

            cols[cell[1]]--;
            if(cols[cell[1]]==0) return i;
        }
        return -1;
    }
}