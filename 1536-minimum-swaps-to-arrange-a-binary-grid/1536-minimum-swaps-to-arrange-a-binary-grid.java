class Solution {
    public int minSwaps(int[][] grid) {
        int zero[]=new int[grid.length];

        for(int i=0;i<grid.length;i++){
            int cnt=0;
            for(int j=grid.length-1;j>=0;j--){
                if(grid[i][j]==0) cnt++;
                else break;
            }zero[i]=cnt;
        }
        int ans=0;

        for(int i=0;i<grid.length;i++){
            int reqzero=grid.length-1-i;
            int j=i;

            while(j<grid.length && zero[j]<reqzero) j++;

            if(j==grid.length) return -1;

            while(j>i){
                int temp=zero[j];
                zero[j]=zero[j-1];
                zero[j-1]=temp;
                ans++;
                j--;
            }
        }return ans;
    }
}